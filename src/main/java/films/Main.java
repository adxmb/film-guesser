package films;

import films.objects.IdGenerator;
import films.services.GetFilmDetailsService;
import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();
    String json = new GetFilmDetailsService(IdGenerator.getRandomId()).send();
    new CommandLineInterface(json).start();
  }
}
