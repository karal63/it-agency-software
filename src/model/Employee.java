package model;

import java.util.Scanner;

public class Employee extends User {
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
        System.out.println("2. Create project");
        System.out.println("3. Create task");
        System.out.println("4. Close task");
        System.out.println("5. Show employees");
        System.out.println("6. Show personal info");
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
            case 6:
                System.out.println("➡️  Redirecting to Account...");

                System.out.println();
                    
                System.out.println("==================================");
                System.out.println("   " + 123 + "   ");
                System.out.println("==================================");
                super.getProjects(scanner);

            default:
                System.out.println("❌ Invalid option. Please try again.");
                break;
        }
    }


    public void updateRole(String newRole) {
        System.out.println("Updating employee role to: " + newRole);
    }

    public void getEmployeeInfo() {
        System.out.println("Employee Info:");
    }
}
