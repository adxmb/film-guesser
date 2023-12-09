package films;

public class State {

  // Singleton
  private static State instance = new State();

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
