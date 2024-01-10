package films.ui.cli;

import films.State;
import films.objects.MovieGenerator;
import films.util.Console;
import java.util.Scanner;

public class GameSelect {

  Scanner scanner = new Scanner(System.in);

  /** Asks the user to choose a difficulty. If the user's input is invalid, the method is called */
  public void askDifficulty() {
    Console.log("Choose a difficulty: ");
    Console.log("1. Easy");
    Console.log("2. Hard");
    String input = scanner.nextLine().strip().toLowerCase();
    if (input.equals("1") || input.equals("easy")) {
      State.get().difficulty = State.Difficulty.EASY;
    } else if (input.equals("2") || input.equals("hard")) {
      State.get().difficulty = State.Difficulty.HARD;
    } else {
      Console.error("Invalid difficulty. Please try again.");
      askDifficulty();
    }
    MovieGenerator.init();
  }
}
