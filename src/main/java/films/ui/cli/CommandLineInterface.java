package films.ui.cli;

import films.objects.json.FilmInfo;
import films.ui.UserInterface;
import films.util.Console;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {
  private static final int MAX_TURNS = 6;
  private static final String REGEX = "(\\s|-|'|\\.|!)";

  private FilmInfo film;
  private int turn;
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
    Console.log("\nGuess the movie!");
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
      if (readGuess()) {
        Console.success("Correct!");
        scanner.close();
        return;
      } else {
        Console.error("Incorrect!");
        turn++;
      }
    }
    // Only executed if the user has not guessed the movie after the maximum number of turns
    Console.error("You lose! The movie was " + film.getTitle() + ".");
    scanner.close();
  }

  /**
   * Reads the user's guess from the command line and compares it to the movie's title.
   *
   * @return true if the user's guess is correct, false otherwise
   */
  public boolean readGuess() {
    String guess = scanner.nextLine().trim().toLowerCase().replaceAll(REGEX, "");
    String title = film.getTitle().toLowerCase().replaceAll(REGEX, "");
    return guess.equals(title);
  }

  /**
   * Prints the information the player needs to know for the turn. Asks for the movie's name after
   * printing details.
   */
  public void printDetails() {
    Console.info("\nTurn " + turn + ":");
    Console.log("Release year: " + film.getYear());
    // Please lmk if there's a better way to do this
    if (turn > 1) Console.log("Rating: " + film.getRated());
    if (turn > 2) Console.log("Runtime: " + film.getRuntime());
    if (turn > 3) Console.log("Genre(s): " + film.getGenre());
    if (turn > 4) Console.log("Director(s): " + film.getDirectors());
    if (turn > 5) Console.log("Cast: " + film.getCast());
    Console.log("\nName the movie: ");
  }
}
