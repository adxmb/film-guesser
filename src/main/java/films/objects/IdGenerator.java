package films.objects;

public class IdGenerator {
  // Used to store the ids of the films in the database
  private static String[] ids = new String[] {"tt0111161"};

  /**
   * Method to retrieve a random id from the array of ids to be used as the id of a film.
   *
   * @return a random id from the array of ids
   */
  public static String getRandomId() {
    return ids[(int) (Math.random() * ids.length)];
  }
}
