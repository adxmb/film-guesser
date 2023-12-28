package films;

import films.services.GetFilmDetailsService;
import films.ui.cli.CommandLineInterface;
import films.util.Config;

public class Main {
  public static void main(String[] args) {
    Config.read();

    // The Shawshank Redemption
    String json = new GetFilmDetailsService("tt0111161").send();

    CommandLineInterface ui = new CommandLineInterface(json);
    ui.start();

    // FilmInfo film = ui.film;
    // System.out.println(
    //     "\n"
    //         + film.getTitle()
    //         + " ("
    //         + film.getYear()
    //         + ")"
    //         + ", directed by "
    //         + film.getDirectors()
    //         + ", written by "
    //         + film.getWriters()
    //         + ", starring "
    //         + film.getCast()
    //         + ".\n");
  }
}
