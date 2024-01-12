package films;

import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();
    Game game = new Game(new CommandLineInterface());
    game.start();
  }
}
