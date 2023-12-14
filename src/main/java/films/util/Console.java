package films.util;

public class Console {

  private enum Colour {
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CYAN("\033[0;36m"),
    RESET("\033[0m");

    private String code;

    Colour(String code) {
      this.code = code;
    }

    public String toString() {
      return code;
    }
  }

  private static void log(String message, Colour colour) {
    System.out.println(String.format(colour + message + Colour.RESET));
  }

  public static void log(String message) {
    log(message, Colour.RESET);
  }

  public static void error(String message) {
    log(message, Colour.RED);
  }

  public static void success(String message) {
    log(message, Colour.GREEN);
  }

  public static void warn(String message) {
    log(message, Colour.YELLOW);
  }

  public static void info(String message) {
    log(message, Colour.BLUE);
  }
}
