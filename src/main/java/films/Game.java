package films;

import films.objects.MovieGenerator;
import films.ui.UserInterface;

public class Game {

  private static final int MAX_TURNS = 6;

  private UserInterface ui;

  /**
   * Creates a new game with the given user interface.
   *
   * @param ui the user interface to use for the game
   */
  public Game(UserInterface ui) {
    this.ui = ui;
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
      if (getAndCheckGuess()) {
        ui.showWin();
        ui.close();
        return;
      } else {
        ui.showIncorrect();
        State.get().turn++;
      }
    }
    // Only executed if the user has not guessed the movie after the maximum number of turns
    ui.showLose(State.get().film);
    ui.close();
  }

  /**
   * Requests a guess from the user and compares it to the movie's title.
   *
   * @return true if the user's guess is correct, false otherwise
   */
  private boolean getAndCheckGuess() {
    String guess = formatForComparison(ui.askGuess());
    String correctTitle = formatForComparison(State.get().film.getTitle());
    return guess.equals(correctTitle);
  }

  /**
   * Formats the given string for comparison by removing whitespace and punctuation and converting
   * to lowercase.
   *
   * @param input the string to format.
   * @return the formatted string.
   */
  private String formatForComparison(String input) {
    return input.trim().toLowerCase().replaceAll("(\\s|-|'|\\.|!)", "");
  }
}
