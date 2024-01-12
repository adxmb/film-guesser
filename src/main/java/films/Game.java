package films;

import films.objects.MovieGenerator;
import films.ui.UserInterface;
import films.util.Console;

public class Game {

  private static final int MAX_TURNS = 6;

  private State state;
  private UserInterface ui;

  /**
   * Creates a new game with state and the given user interface.
   *
   * @param ui the user interface to use for the game
   */
  public Game(UserInterface ui) {
    this.state = new State();
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

    state.difficulty = ui.askDifficulty();
    state.film = MovieGenerator.getRandomMovieDetails(state.difficulty);

    ui.showIntroduction();
    Console.info("[DEBUG] Answer: " + state.film.getTitle()); // TODO: remove this line

    while (state.gameRunning) {
      takeTurn();
    }

    if (!ui.askRestart()) {
      Main.stopApp();
    }
  }

  private void takeTurn() {
    ui.showFilmDetails(state.film, state.turn);
    if (getAndCheckGuess()) {
      ui.showWin();
      state.gameRunning = false;
    } else if (state.turn >= MAX_TURNS) {
      ui.showLose(state.film);
      state.gameRunning = false;
    } else {
      ui.showIncorrect();
      state.turn++;
    }
  }

  /**
   * Requests a guess from the user and compares it to the movie's title.
   *
   * @return true if the user's guess is correct, false otherwise
   */
  private boolean getAndCheckGuess() {
    String guess = formatForComparison(ui.askGuess());
    String correctTitle = formatForComparison(state.film.getTitle());
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
