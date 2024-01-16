package films.ui;

import films.State;
import films.objects.json.FilmInfo;

public interface UserInterface {
  /** Place for miscellaneous setup tasks. Should be called at the start of the game. */
  void start();

  /**
   * Asks the user to choose a difficulty level.
   *
   * @return The difficulty level chosen by the user.
   */
  State.Difficulty askDifficulty();

  /** Displays the introduction to the game. */
  void showIntroduction();

  /**
   * Displays the current turn and the corresponding information about the movie available to the
   * user.
   *
   * @param film The movie whose details are to be displayed.
   * @param turn The current turn number.
   */
  void showFilmDetails(FilmInfo film, int turn);

  /**
   * Asks the user to guess the movie.
   *
   * @return The user's guess.
   */
  String askGuess();

  /** Displayed when the user inputs an incorrect guess. */
  void showIncorrect();

  /** Displayed when the user inputs a correct guess, winning the game. */
  void showWin();

  /**
   * Displayed when the user runs out of turns, losing the game. Reveals the correct title of the
   * movie.
   *
   * @param film The movie whose title is to be displayed.
   */
  void showLose(FilmInfo film);

  /** Place for miscellaneous cleanup tasks. Should be called at the end of the game. */
  boolean askRestart();
}
