import java.util.Scanner;

public class product {
    String name;
    double price;   
    int quantity;

    public product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }   
    public double calculateTotalPrice() {
        return price * quantity;
    }

    public double discountedPrice(double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        
        product p = new product(name, price, quantity);
        
        System.out.println("Total Price: " + p.calculateTotalPrice());
        
        System.out.print("Enter discount percentage: ");
        double discountPercentage = scanner.nextDouble();
        
        System.out.println("Discounted Price: " + p.discountedPrice(discountPercentage));
        
        scanner.close();
    }
}