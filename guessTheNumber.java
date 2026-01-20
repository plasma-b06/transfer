import java.util.Scanner;
import java.util.Random;

public class guessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);

        System.out.println(" Welcome to Guess the Number!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

        int guess = 0;
        int attempts = 0;

        while (true) {
            System.out.print("Enter your guess: ");

            if (!sc.hasNextInt()) {
                System.out.println(" Invalid input! Please enter a valid integer.");
                sc.next();
                continue;
            }

            guess = sc.nextInt();
            attempts++;

            if (guess < 1 || guess > 100) {
                System.out.println(" Please enter a number between 1 and 100.");
                continue;
            }

            if (guess < secretNumber) {
                System.out.println(" Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println(" Too high! Try again.");
            } else {
                System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        sc.close();
    }
}
