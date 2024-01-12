package films;

import films.objects.json.FilmInfo;

public class State {

  public enum Difficulty {
    EASY,
    HARD
  }

  // Package-private
  Difficulty difficulty;
  FilmInfo film;
  int turn;

  State() {
    // Default state
    difficulty = null;
    film = null;
    turn = 1;
  }
}
