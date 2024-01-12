package films.ui.cli;

import films.State;
import films.objects.json.FilmInfo;
import films.ui.UserInterface;
import films.util.Console;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {

  private Scanner scanner = new Scanner(System.in);

  @Override
  public void start() {
    Console.log("\nWelcome to the Films game!");
  }

  @Override
  public State.Difficulty askDifficulty() {
    return new GameSelect().askDifficulty();
  }

  @Override
  public void showIntroduction() {
    Console.log("\nGuess the movie!");
  }

  /** Prints the information the player needs to know for the turn. */
  @Override
  public void showFilmDetails(FilmInfo film, int turn) {
    Console.info("\nTurn " + turn + ":");
    Console.log("Release year: " + film.getYear());
    // Please lmk if there's a better way to do this
    if (turn > 1) Console.log("Rating: " + film.getRated());
    if (turn > 2) Console.log("Runtime: " + film.getRuntime());
    if (turn > 3) Console.log("Genre(s): " + film.getGenre());
    if (turn > 4) Console.log("Director(s): " + film.getDirectors());
    if (turn > 5) Console.log("Cast: " + film.getCast());
  }

  /** Requests user input for the movie's name. */
  @Override
  public String askGuess() {
    Console.log("\nName the movie: ");
    return scanner.nextLine();
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
  public void close() {
    scanner.close();
  }
}
