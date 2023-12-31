package films.objects;

import films.services.GetTop1000MoviesService;
import films.util.Console;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MovieGenerator {
  // Used to store the ids of the films in the database
  private static ArrayList<String> movieNames;

  static {
    try {
      String data = new GetTop1000MoviesService().send();
      parse(data);
    } catch (IOException e) {
      Console.error("Failed to read data from the internet. Quitting...");
      System.exit(0);
    } catch (RuntimeException e) {
      Console.error("Failed to connect to the internet. Quitting...");
      System.exit(0);
    }
  }

  private static void parse(String data) throws IOException {
    movieNames = new ArrayList<>();
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
   * Method to retrieve a random id from the array of ids to be used as the id of a film.
   *
   * @return a random id from the array of ids
   */
  public static String getRandomName() {
    String id = movieNames.get((int) (Math.random() * movieNames.size()));
    return id;
  }
}
