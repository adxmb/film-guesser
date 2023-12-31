package films;

import films.objects.MovieGenerator;
import films.services.GetFilmDetailsByNameService;
import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();
    String json = new GetFilmDetailsByNameService(MovieGenerator.getRandomName()).send();
    new CommandLineInterface(json).start();
  }
}
