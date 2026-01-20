import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        System.out.println("🪨📄✂️ Welcome to Rock, Paper, Scissors!");
        System.out.println("Type 'r' for rock, 'p' for paper, or 's' for scissors.");

        while (playAgain) {
            System.out.print("Enter your choice (r/p/s): ");
            String userInput = sc.next().toLowerCase();

            String userChoice = "";
            switch (userInput) {
                case "r": userChoice = "rock"; break;
                case "p": userChoice = "paper"; break;
                case "s": userChoice = "scissors"; break;
                default:
                    System.out.println("⚠️ Invalid input! Please enter 'r', 'p', or 's'.");
                    continue;
            }

            String[] options = {"rock", "paper", "scissors"};
            String computerChoice = options[random.nextInt(3)];

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("🤝 It's a tie!");
            } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
            ) {
                System.out.println("🎉 You win!");
            } else {
                System.out.println("💻 Computer wins!");
            }

            System.out.print("Play again? (y/n): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("👋 Thanks for playing!");
        sc.close();
    }
}
