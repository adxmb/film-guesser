package films.ui.cli;

import films.State;
import films.util.Console;
import java.util.Scanner;

public class GameSelect {

  private Scanner scanner = new Scanner(System.in);

  /** Asks the user to choose a difficulty. If the user's input is invalid, the method is called */
  public State.Difficulty askDifficulty() {
    State.Difficulty difficulty = null;

    while (difficulty == null) {
      Console.log("\nChoose a difficulty: ");
      Console.log("1. Easy");
      Console.log("2. Hard");
      String input = scanner.nextLine().strip().toLowerCase();

      switch (input) {
        case "1":
        case "easy":
          difficulty = State.Difficulty.EASY;
          break;
        case "2":
        case "hard":
          difficulty = State.Difficulty.HARD;
          break;
        default:
          Console.error("Invalid difficulty. Please try again.");
      }
    }

    return difficulty;
  }
}
