import java.util.Scanner;

public class operations{
    public static double add(int a, int b) {
        return a + b;
    }
    public static double subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }
    public static double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }
    public static double squareRoot(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot take square root of a negative number");     
        }
        else {
            return Math.sqrt(a);
        }
    }
    public static double absolute(int a) {
        return Math.abs(a);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first number: ");
            int a = sc.nextInt();
            System.out.println("Enter second number: ");
            int b = sc.nextInt();
            int c = new operations().multiply(a, b);
            System.out.println("Addition: " + add(a, b));
            System.out.println("Subtraction: " + subtract(a, b));
            System.out.println("Multiplication: " +c);
            System.out.println("Division: " + divide(a, b));
            System.out.println("Power: " + power(a, b));
            System.out.println("Square Root of first number: " + squareRoot(a));
            System.out.println("Absolute value of first number: " + absolute(a));
        }
        catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}