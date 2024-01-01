package films;

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

  private State() {
    // Default state
  }

  public static void reset() {
    instance = new State();
  }

  public static State get() {
    return instance;
  }
}
