package films;

import films.objects.MovieGenerator;
import films.ui.UserInterface;
import films.util.Console;
import java.util.Scanner;

public class Game {

  private static final int MAX_TURNS = 6;
  private static final String IGNORE_CHAR_REGEX = "(\\s|-|'|\\.|!)";

  private UserInterface ui;
  private Scanner scanner;

  /**
   * Creates a new game with the given user interface.
   *
   * @param ui The user interface to use for the game.
   */
  public Game(UserInterface ui) {
    this.ui = ui;
    this.scanner = new Scanner(System.in);
  }

  /**
   * Starts the game, including the user interface. Prints the details of the movie and asks for the
   * user's guess. If the user's guess is correct, the game ends. If the user's guess is incorrect,
   * the game continues until the user has guessed the movie or the maximum number of turns has been
   * reached.
   */
  public void start() {
    ui.start();

    State.get().difficulty = ui.askDifficulty();
    State.get().film = MovieGenerator.getRandomMovieDetails(State.get().difficulty);

    ui.showIntroduction();

    while (State.get().turn <= MAX_TURNS) {
      ui.showFilmDetails(State.get().film, State.get().turn);
      if (readGuess()) {
        Console.success("Correct!");
        scanner.close();
        return;
      } else {
        Console.error("Incorrect!");
        State.get().turn++;
      }
    }
    // Only executed if the user has not guessed the movie after the maximum number of turns
    Console.error("You lose! The movie was '" + State.get().film.getTitle() + "'.");
    scanner.close();
  }

  /**
   * Reads the user's guess from the command line and compares it to the movie's title.
   *
   * @return true if the user's guess is correct, false otherwise
   */
  public boolean readGuess() {
    String guess = scanner.nextLine().trim().toLowerCase().replaceAll(IGNORE_CHAR_REGEX, "");
    String title = State.get().film.getTitle().toLowerCase().replaceAll(IGNORE_CHAR_REGEX, "");
    return guess.equals(title);
  }
}
