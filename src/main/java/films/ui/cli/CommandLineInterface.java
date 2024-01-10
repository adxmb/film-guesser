package films.ui.cli;

import films.ui.UserInterface;

public class CommandLineInterface implements UserInterface {
  @Override
  public void start() {
    new GameSelect().askDifficulty();
    System.out.println("Welcome to the Films game!");
  }
}
