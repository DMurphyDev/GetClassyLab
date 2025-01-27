import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    products.add(new Product(fields[0], fields[1], fields[2], Double.parseDouble(fields[3])));
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        System.out.printf("%-15s %-25s %-10s %-10s%n", "Name", "Description", "ID", "Cost");
        for (Product p : products) {
            System.out.printf("%-15s %-25s %-10s %-10.2f%n", p.getName(), p.getDescription(), p.getID(), p.getCost());
        }
    }
}
