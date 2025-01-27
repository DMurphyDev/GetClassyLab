import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    // Default constructor: Uses System.in
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    // Parameterized constructor: Allows passing a Scanner
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    public String getNonZeroLenString(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    public int getInt(String prompt) {
        int result;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine(); // Clear buffer
                return result;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.nextLine(); // Clear invalid input
            }
        }
    }

    public double getDouble(String prompt) {
        double result;
        while (true) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine(); // Clear buffer
                return result;
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.nextLine(); // Clear invalid input
            }
        }
    }

    public boolean getYNConfirm(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            input = pipe.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    public String getRegExString(String prompt, String regEx) {
        String input;
        while (true) {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                return input;
            } else {
                System.out.println("Invalid input. Please match the required format.");
            }
        }
    }
}
