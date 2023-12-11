package films;

import films.services.GetFilmDetailsService;
import films.ui.UserInterface;
import films.ui.cli.CommandLineInterface;

public class Main {
  public static void main(String[] args) {
    UserInterface ui = new CommandLineInterface();
    ui.start();

    // The Shawshank Redemption
    String html = new GetFilmDetailsService("tt0111161").send();
    System.out.println(html);
  }
}
