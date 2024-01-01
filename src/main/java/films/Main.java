package films;

import films.objects.MovieGenerator;
import films.services.GetFilmDetailsByIdService;
import films.services.GetFilmDetailsByNameService;
import films.ui.cli.CommandLineInterface;
import films.ui.cli.GameSelect;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();
    new GameSelect().askDifficulty();

    String json;
    if (State.get().difficulty == State.Difficulty.EASY) {
      json = new GetFilmDetailsByIdService(MovieGenerator.getRandomId()).send();
    } else {
      json = new GetFilmDetailsByNameService(MovieGenerator.getRandomName()).send();
    }

    new CommandLineInterface(json).start();
  }
}
