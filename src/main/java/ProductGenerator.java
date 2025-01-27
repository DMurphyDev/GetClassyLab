import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter product description: ");
            String description = scanner.nextLine();
            System.out.print("Enter product ID: ");
            String ID = scanner.nextLine();
            System.out.print("Enter product cost: ");
            double cost = Double.parseDouble(scanner.nextLine());

            products.add(new Product(name, description, ID, cost));

            System.out.print("Add another product? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.print("Enter the name of the CSV file to save: ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Data saved successfully!");
    }
}
