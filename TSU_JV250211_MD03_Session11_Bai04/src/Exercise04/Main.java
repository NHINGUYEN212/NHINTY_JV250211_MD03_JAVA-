package Exercise04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Product> products = new HashMap<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===========PRODUCTS MANAGER SYSTEM============");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        editProduct();
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        displayProducts();
                        break;
                    case 5:
                        filterProducts();
                        break;
                    case 6:
                        totalValueOfProducts();
                        break;
                    case 0:
                        System.out.println("Thank you for using our program.");
                        System.exit(0);
                    default:
                        System.err.println("Invalid choice. Try again.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid choice");
            }

        } while (true);
    }

    private static void addProduct() {
        System.out.println("Enter product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        products.put(id, new Product(id, name, price));
        System.out.println("Product added successfully");
    }

    private static void editProduct() {
        System.out.println("Enter product ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (products.containsKey(id)) {
            System.out.println("Enter new product Name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new product Price: ");
            double newPrice = Double.parseDouble(scanner.nextLine());
            Product product = products.get(id);
            product.setName(newName);
            product.setPrice(newPrice);
            System.out.println("Edit product successfully");
        } else {
            System.err.println("Product does not exist");
        }
    }

    private static void deleteProduct() {
        System.out.println("Enter product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Product deleted successfully");
        } else {
            System.err.println("Product does not exist");
        }
    }

    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("There are no products in the system");
        } else {
            products.values().forEach(System.out::println);
        }
    }

    private static void filterProducts() {
        System.out.println("Products with price greater than 100: ");
        products.values().stream().filter(product -> product.getPrice() > 100).forEach(System.out::println);

    }

    private static void totalValueOfProducts() {
        double total = products.values().stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total value of products: " + total);
    }
}
