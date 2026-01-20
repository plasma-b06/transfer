public class calculator
{
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        int sum = add(a, b);
        int difference = subtract(a, b);
        int product = multiply(a, b);
        double quotient = divide(a, b);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static double divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) x / y;
    }
}
