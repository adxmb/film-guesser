package films.ui.cli;

import films.State.Difficulty;
import films.objects.json.FilmInfo;
import films.ui.UserInterface;

public class CommandLineInterface implements UserInterface {
  @Override
  public void start() {
    new GameSelect().askDifficulty();
    System.out.println("Welcome to the Films game!");
  }

  @Override
  public Difficulty askDifficulty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'askDifficulty'");
  }

  @Override
  public void showIntroduction() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showIntroduction'");
  }

  @Override
  public void showFilmDetails(FilmInfo film, int turn) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showFilmDetails'");
  }

  @Override
  public String askGuess() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'askGuess'");
  }

  @Override
  public void showWin() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showWin'");
  }

  @Override
  public void showLose(FilmInfo film) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'showLose'");
  }
}
