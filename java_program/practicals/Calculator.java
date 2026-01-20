// File: Calculator.java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Java Calculator =====");

        while (running) {
            // Taking input from user
            System.out.print("\nEnter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter operator (+, -, *, /, %): ");
            char operator = sc.next().charAt(0);

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            double result = 0;
            boolean valid = true;

            // Processing operation
            switch (operator) {
                case '+':
                    result = a + b;
                    break;

                case '-':
                    result = a - b;
                    break;

                case '*':
                    result = a * b;
                    break;

                case '/':
                    if (b == 0) {
                        System.out.println("Error: Division by zero is not allowed!");
                        valid = false;
                    } else {
                        result = a / b;
                    }
                    break;

                case '%':
                    if (b == 0) {
                        System.out.println("Error: Modulus by zero is not allowed!");
                        valid = false;
                    } else {
                        result = a % b;
                    }
                    break;

                default:
                    System.out.println("Invalid operator! Please enter (+, -, *, /, %).");
                    valid = false;
            }

            // Displaying result if valid
            if (valid) {
                System.out.printf("Result: %.2f\n", result);
            }

            // Asking user whether to continue
            System.out.print("\nDo you want to perform another calculation? (y/n): ");
            char choice = sc.next().charAt(0);

            if (choice == 'n' || choice == 'N') {
                running = false;
                System.out.println("Exiting Calculator. Goodbye!");
            }
        }

        sc.close();
    }
}
