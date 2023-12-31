package films.objects;

import java.util.ArrayList;

import films.services.GetTop100MoviesService;
import films.util.Console;

public class IdGenerator {
  // Used to store the ids of the films in the database
  private static ArrayList<String> ids;

  static {
    try {
      String json = new GetTop100MoviesService().send();
      String[] films = json.substring(1, json.length() - 1).split("\\},");
      parse(films);
    } catch (RuntimeException e) {
      e.printStackTrace();
      Console.error("Failed to connect to the internet. Quitting...");
      System.exit(0);
    }
  }

  private static void parse(String[] results) {
    ids = new ArrayList<>();
    for (String result : results) {
      ids.add(getId(result));
    }
  }

  private static String getId(String jsonFragment) {
    // Find sequence `imdbID: "` and get the next 9 characters
    int startIndex = jsonFragment.indexOf("\"id\": \"") + 7;
    if (startIndex == -1) {
      throw new IllegalArgumentException("No imdbID found in result");
    }
    return jsonFragment.substring(startIndex, startIndex + 9);
  }

  /**
   * Method to retrieve a random id from the array of ids to be used as the id of a film.
   *
   * @return a random id from the array of ids
   */
  public static String getRandomId() {
    String id = ids.get((int) (Math.random() * ids.size()));
    return id;
  }
}
