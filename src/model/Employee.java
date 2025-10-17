package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Employee extends User {
    private String dbEmployees = "src/data/employees.txt";

    public Employee(String username, String password) {
        super(username, password, "employee");
        System.out.println("Employee created.");
    }

    @Override
    public void showDashboard(Scanner scanner) {
        System.out.println("==================================");
        System.out.println("   Employee Dashboard   ");
        System.out.println("==================================");
        System.out.println("Please select an option:");
        
        System.out.println("1. Show projects");
        System.out.println("2. Create task");
        System.out.println("3. Close task");
        System.out.println("4. Show employees");
        System.out.println("5. Show personal info");
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
                super.getProjects(scanner);
                break;
            case 4:
                getEmployees();
                break;
            case 5:
                System.out.println("➡️  Redirecting to Account...");

                System.out.println();
                    
                System.out.println("==================================");
                System.out.println("   Profile Information   ");
                System.out.println("==================================");
                super.getProfileInfo();
                break;
            default:
                System.out.println("❌ Invalid option. Please try again.");
                break;
        }
    }

    public void updateRole(String newRole) {
        System.out.println("Updating employee role to: " + newRole);
    }

    public void getEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbEmployees))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                String email = parts[0];
                String contact = parts[2];
                System.out.println(index + email + "Contact: " + contact);

                index++;
            }
        } catch (IOException e) {
            System.err.println("Error reading tasks file: " + e.getMessage());
        }
    }

    
}
