public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        // Test getNonZeroLenString
        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("Your name is: " + name);

        // Test getInt
        int age = input.getInt("Enter your age");
        System.out.println("Your age is: " + age);

        // Test getDouble
        double salary = input.getDouble("Enter your salary");
        System.out.println("Your salary is: " + salary);

        // Test getYNConfirm
        boolean confirm = input.getYNConfirm("Do you like programming");
        System.out.println("Confirmation: " + (confirm ? "Yes" : "No"));

        // Test getRegExString
        String email = input.getRegExString("Enter your email", "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        System.out.println("Your email is: " + email);
    }
}
