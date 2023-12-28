package films;

import films.objects.json.FilmInfo;
import films.services.GetFilmDetailsService;
import films.ui.UserInterface;
import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();

    UserInterface ui = new CommandLineInterface();
    ui.start();

    // The Shawshank Redemption
    String json = new GetFilmDetailsService("tt0111161").send();
    FilmInfo film = new FilmInfo(json);
    System.out.println(
        "\n"
            + film.getTitle()
            + " ("
            + film.getYear()
            + ")"
            + ", directed by "
            + film.getDirectors()
            + ", written by "
            + film.getWriters()
            + ", starring "
            + film.getCast()
            + ".\n");
  }
}
