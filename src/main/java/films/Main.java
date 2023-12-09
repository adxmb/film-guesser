package films;

import films.ui.UserInterface;
import films.ui.cli.CommandLineInterface;

public class Main {
  public static void main(String[] args) {
    UserInterface ui = new CommandLineInterface();
    ui.start();
  }
}
