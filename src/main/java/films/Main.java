package films;

import films.objects.IdGenerator;
import films.services.GetFilmDetailsService;
import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();

    // The Shawshank Redemption
    String json = new GetFilmDetailsService(IdGenerator.getRandomId()).send();

    CommandLineInterface ui = new CommandLineInterface(json);
    ui.start();
  }
}
