package films.ui.cli;

import films.objects.json.FilmInfo;
import films.ui.UserInterface;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {
  private static final int MAX_TURNS = 8;

  public FilmInfo film;
  public int turn;
  private Scanner scanner;

  /**
   * Creates a CommandLineInterface object from a JSON string. Creates a FilmInfo object from the
   * JSON string. Sets the turn to 1 as the game has just started.
   *
   * @param json The JSON string to extract the data from.
   */
  public CommandLineInterface(String json) {
    this.film = new FilmInfo(json);
    this.turn = 1;
    this.scanner = new Scanner(System.in);
  }

  /**
   * Starts the game. Prints the details of the movie and asks for the user's guess. If the user's
   * guess is correct, the game ends. If the user's guess is incorrect, the game continues until the
   * user has guessed the movie or the maximum number of turns has been reached.
   */
  @Override
  public void start() {
    while (turn <= MAX_TURNS) {
      printDetails();
      if (readGuess(film.getTitle())) {
        System.out.println("Correct!");
        scanner.close();
        return;
      } else {
        System.out.println("Incorrect!");
        turn++;
      }
    }
    // Only executed if the user has not guessed the movie after the maximum number of turns
    System.out.println("You lose!");
    scanner.close();
  }

  /**
   * Reads the user's guess from the command line and compares it to the movie's title.
   *
   * @return true if the user's guess is correct, false otherwise
   */
  public boolean readGuess(String title) {
    String guess = scanner.nextLine().trim().replaceAll(" ", "").replaceAll("-", "");
    title = title.toLowerCase().replaceAll(" ", "").replaceAll("-", "");
    return guess.toLowerCase().equals(title);
  }

  // TODO: Print details based on the turn only
  /**
   * Prints the information the player needs to know for the turn. Asks for the movie's name after
   * printing details.
   */
  public void printDetails() {
    System.out.println("\nTurn " + turn + ":");
    System.out.println("Release year: " + film.getYear());
    System.out.println("Rating: " + film.getRated());
    System.out.println("Runtime: " + film.getRuntime());
    System.out.println("Genre(s): " + film.getGenre());
    System.out.println("Director(s): " + film.getDirectors());
    System.out.println("Writer(s): " + film.getWriters());
    System.out.println("Cast: " + film.getCast());
    System.out.println("\nName the movie: ");
  }
}
