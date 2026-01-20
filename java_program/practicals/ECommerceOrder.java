class Order {
    private int orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private double price;

    // Constructor 1: Default order
    Order() {
        this.orderId = 0;
        this.customerName = "Unknown";
        this.productName = "Not Assigned";
        this.quantity = 0;
        this.price = 0.0;
    }

    // Constructor 2: Order with basic details
    Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = "Not Assigned";
        this.quantity = 0;
        this.price = 0.0;
    }

    // Constructor 3: Full order details
    Order(int orderId, String customerName, String productName, int quantity, double price) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Method to calculate total price
    public double calculateTotal() {
        return quantity * price;
    }

    // Display order details
    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per Unit: ₹" + price);
        System.out.println("Total Amount: ₹" + calculateTotal());
        System.out.println("---------------------------");
    }
}

public class ECommerceOrder {
    public static void main(String[] args) {
        // Using different constructors
        Order order1 = new Order();  // Default
        Order order2 = new Order(101, "Amit");  // Partial
        Order order3 = new Order(102, "Priya", "Laptop", 2, 55000.50);  // Full

        // Displaying orders
        System.out.println("=== E-Commerce Order Processing System ===");
        order1.displayOrder();
        order2.displayOrder();
        order3.displayOrder();
    }
}
