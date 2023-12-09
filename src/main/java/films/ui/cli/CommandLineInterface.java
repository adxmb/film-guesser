package films.ui.cli;

import films.ui.UserInterface;

public class CommandLineInterface implements UserInterface {

  @Override
  public void start() {
    System.out.println("CLI started!");
  }
}
