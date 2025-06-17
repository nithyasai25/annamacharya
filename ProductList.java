import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductList {
    private ArrayList<Product> products;

    public ProductList() {
        products = new ArrayList<>();
    }

    public void addProduct(String name, String number, double price) {
        products.add(new Product(name, number, price));
    }

    public void removeProduct(String name) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    public Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void listProductsByPriceAscending() {
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(System.out::println);
    }

    public void listProductsByPriceDescending() {
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductList productList = new ProductList();

        System.out.println("Welcome to the Product List!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product");
            System.out.println("4. List All Products");
            System.out.println("5. List Products by Price (Ascending)");
            System.out.println("6. List Products by Price (Descending)");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    productList.addProduct(name, number, price);
                    System.out.println("Product added successfully.");
                    break;
                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    productList.removeProduct(removeName);
                    System.out.println("Product removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter name to find: ");
                    String findName = scanner.nextLine();
                    Product found = productList.findProduct(findName);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    productList.listProducts();
                    break;
                case 5:
                    System.out.println("Products by Price (Ascending):");
                    productList.listProductsByPriceAscending();
                    break;
                case 6:
                    System.out.println("Products by Price (Descending):");
                    productList.listProductsByPriceDescending();
                    break;
                case 7:
                    System.out.println("Exiting Product List. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static class Product {
        private String name;
        private String number;
        private double price;

        public Product(String name, String number, double price) {
            this.name = name;
            this.number = number;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + number + ") - ₹" + price;
        }
    }
}
