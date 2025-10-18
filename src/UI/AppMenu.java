// ...existing code...
package UI;
import java.util.Scanner;

import model.Client;
import model.Employee;
import model.User;

public class AppMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("==================================");
        System.out.println("   Welcome to IT Agency System   ");
        System.out.println("==================================");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        switch (choice) {
            case 1:
                System.out.println("➡️  Redirecting to Login...");
                login(scanner);
                break;

            case 2:
                System.out.println("➡️  Redirecting to Sign Up...");
                break;

            default:
                System.out.println("❌ Invalid option. Please try again.");
                break;
        }
    }
    
    public void login(Scanner scanner) {
        System.out.println();
        System.out.println("===== LOGIN =====");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Are you a (1) Client or (2) Employee? ");
        int role = scanner.nextInt();

        User user;
        if (role == 1) {
            user = new Client(email, password);
        } else {
            user = new Employee(email, password);
        }
        if (user.login()) {
            user.showDashboard(scanner);
        }
    }
}