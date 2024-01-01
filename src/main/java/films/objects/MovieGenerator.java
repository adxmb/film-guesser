package films.objects;

import films.State;
import films.services.GetTop1000MoviesService;
import films.services.GetTop100MoviesService;
import films.util.Console;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MovieGenerator {
  // Used to store the ids of the films in the database
  private static ArrayList<String> movieIds = new ArrayList<>(); // Easy mode
  private static ArrayList<String> movieNames = new ArrayList<>(); // Hard mode

  /**
   * Method to initialise the array of names/ids by reading the data from the internet and parsing
   * it. Call after difficulty has been set. Ends the program if the data cannot be read.
   */
  public static void init() {
    try {
      if (State.get().difficulty == State.Difficulty.EASY) {
        String data = new GetTop100MoviesService().send();
        parseJson(data);
      } else {
        String data = new GetTop1000MoviesService().send();
        parseCsv(data);
      }
    } catch (IOException e) {
      Console.error("Failed to read data from the internet. Quitting...");
      System.exit(0);
    } catch (RuntimeException e) {
      Console.error("Failed to connect to the internet. Quitting...");
      System.exit(0);
    }
  }

  /**
   * Method to parse csv data (GetTop1000MoviesService) from the internet into the array of names.
   *
   * @param data the csv data to parse
   * @throws IOException if the data cannot be parsed
   */
  private static void parseCsv(String data) throws IOException {
    CSVFormat format =
        CSVFormat.Builder.create().setSkipHeaderRecord(true).setIgnoreEmptyLines(true).build();
    CSVParser parser = CSVParser.parse(data, format);

    boolean first = true;
    for (CSVRecord csvRecord : parser) {
      if (first) {
        first = false;
        continue; // Skip the headers
      }
      String name = csvRecord.get(1);
      movieNames.add(name);
    }
  }

  /**
   * Method to parse json data (GetTop100MoviesService) from the internet into the array of ids.
   *
   * @param data the json data to parse
   * @throws IOException if the data cannot be parsed
   */
  private static void parseJson(String data) throws IOException {
    String[] films = data.substring(1, data.length() - 1).split("\\},");
    for (String film : films) {
      movieIds.add(getJsonId(film));
    }
  }

  /**
   * Method to retrieve the id from a json fragment.
   *
   * @param jsonFragment the json fragment to retrieve the id from
   * @return the id of the film
   * @throws IOException if the id cannot be found
   */
  private static String getJsonId(String jsonFragment) throws IOException {
    // Find sequence `imdbID: "` and get the next 9 characters
    int startIndex = jsonFragment.indexOf("\"id\": \"") + 7;
    if (startIndex == -1) {
      throw new IOException("No imdbID found in result");
    }
    return jsonFragment.substring(startIndex, startIndex + 9);
  }

  /**
   * Method to retrieve a random id from the array of ids to be used as the id of a film.
   *
   * @return a random id from the array of ids
   * @throws RuntimeException if the method is called in hard mode
   */
  public static String getRandomId() {
    if (State.get().difficulty == State.Difficulty.HARD) {
      throw new RuntimeException("Use getRandomName() in hard mode");
    }
    String id = movieIds.get((int) (Math.random() * movieIds.size()));
    return id;
  }

  /**
   * Method to retrieve a random id from the array of ids to be used as the id of a film.
   *
   * @return a random id from the array of ids
   * @throws RuntimeException if the method is called in easy mode
   */
  public static String getRandomName() {
    if (State.get().difficulty == State.Difficulty.EASY) {
      throw new RuntimeException("Use getRandomId() in easy mode");
    }
    String id = movieNames.get((int) (Math.random() * movieNames.size()));
    return id;
  }
}
