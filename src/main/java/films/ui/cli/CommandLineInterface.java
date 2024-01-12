package films.ui.cli;

import films.State;
import films.objects.json.FilmInfo;
import films.ui.UserInterface;
import films.util.Console;

public class CommandLineInterface implements UserInterface {
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
    Console.log("\nName the movie: ");
  }

  /** Requests user input for the movie's name. */
  @Override
  public String askGuess() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'askGuess'");
  }

  @Override
  public void showWin() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showWin'");
  }

  @Override
  public void showLose(FilmInfo film) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showLose'");
  }
}
