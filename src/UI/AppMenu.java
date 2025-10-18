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
        System.out.println("1. Login (selected)");
        System.out.println("");

        System.out.println("Press any button to continue...");
        String action = scanner.nextLine();

        System.out.println("➡️  Redirecting to Login...");
        login(scanner);
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