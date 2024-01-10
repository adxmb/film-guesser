package films;

import films.ui.UserInterface;
import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();
    UserInterface ui = new CommandLineInterface();
    Game game = new Game(ui);
    game.start();
  }
}
