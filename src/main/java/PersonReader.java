import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    people.add(new Person(fields[0], fields[1], fields[2], fields[3], Integer.parseInt(fields[4])));
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        System.out.printf("%-10s %-10s %-10s %-10s %-4s%n", "First Name", "Last Name", "ID", "Title", "YOB");
        for (Person p : people) {
            System.out.printf("%-10s %-10s %-10s %-10s %-4d%n", p.getFirstName(), p.getLastName(), p.getID(), p.getTitle(), p.getYOB());
        }
    }
}
