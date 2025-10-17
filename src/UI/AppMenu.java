// ...existing code...
package UI;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        User user = new User(email, password, "employee");
        boolean success = user.login();
        if (success) {
            showProjects(email, user, scanner);
        }
    }

    public void showProjects(String email, User user, Scanner scanner) {
        System.out.println("==================================");
        System.out.println("   Welcome " + email + "   ");
        System.out.println("==================================");
        System.out.println("Please select an option:");
        System.out.println("1. Show projects");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.println("➡️  Redirecting to Projects...");

                System.out.println();
                
                System.out.println("==================================");
                System.out.println("   All projects   ");
                System.out.println("==================================");
                user.getProjects(scanner);
                break;

            default:
                System.out.println("❌ Invalid option. Please try again.");
                break;
        }

    }

}