package films;

import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {

  public static void main(String[] args) {
    Config.read();
    while (true) {
      restartGame();
    }
  }

  public static void restartGame() {
    new Game(new CommandLineInterface()).start();
  }
}
