package films;

import films.objects.json.FilmInfo;

public class State {

  public enum Difficulty {
    EASY,
    HARD
  }

  // Singleton
  private static State instance;

  static {
    reset();
  }

  public Difficulty difficulty;
  public FilmInfo film;
  public int turn;

  private State() {
    // Default state
    difficulty = null;
    film = null;
    turn = 1;
  }

  public static void reset() {
    instance = new State();
  }

  public static State get() {
    return instance;
  }
}
