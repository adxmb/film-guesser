package films.ui.cli;

import films.State;
import films.objects.json.FilmInfo;
import films.ui.UserInterface;
import films.util.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** See UserInterface for method descriptions. */
public class CommandLineInterface implements UserInterface {

  private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

  @Override
  public void start() {
    Console.success("\nWelcome to the Films game!");
  }

  @Override
  public State.Difficulty askDifficulty() {
    State.Difficulty difficulty = null;

    while (difficulty == null) {
      Console.log("\nChoose a difficulty: ");
      Console.log("1. Easy");
      Console.log("2. Hard");
      String input = readInputLine().strip().toLowerCase();

      switch (input) {
        case "1":
        case "easy":
          difficulty = State.Difficulty.EASY;
          break;
        case "2":
        case "hard":
          difficulty = State.Difficulty.HARD;
          break;
        default:
          Console.error("Invalid difficulty. Please try again.");
      }
    }

    return difficulty;
  }

  @Override
  public void showIntroduction() {
    Console.log("\nGuess the movie!");
  }

  @Override
  public void showFilmDetails(FilmInfo film, int turn) {
    Console.info("\nTurn " + turn + ":");
    Console.log("Release year: " + film.getYear());

    if (turn > 1) Console.log("Rating: " + film.getRated());
    if (turn > 2) Console.log("Runtime: " + film.getRuntime());
    if (turn > 3) Console.log("Genre(s): " + film.getGenre());
    if (turn > 4) Console.log("Director(s): " + film.getDirectors());
    if (turn > 5) Console.log("Cast: " + film.getCast());
  }

  @Override
  public String askGuess() {
    Console.log("\nName the movie: ");
    return readInputLine();
  }

  @Override
  public void showIncorrect() {
    Console.error("Incorrect!");
  }

  @Override
  public void showWin() {
    Console.success("Correct!");
  }

  @Override
  public void showLose(FilmInfo film) {
    Console.error("You lose! The movie was '" + film.getTitle() + "'.");
  }

  @Override
  public boolean askRestart() {
    while (true) {
      Console.log("\nPlay again? (y/n)");
      String input = readInputLine().strip().toLowerCase();

      switch (input) {
        case "y":
        case "yes":
          return true;
        case "n":
        case "no":
          return false;
        default:
          Console.error("Invalid input.");
      }
    }
  }

  private String readInputLine() {
    try {
      String line = READER.readLine();
      return line;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
