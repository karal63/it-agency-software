package model;

import java.util.Scanner;

public class Employee extends User {
    private AgencyManagementSystem agencySystem = new AgencyManagementSystem();

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
        
        System.out.println("1. Show projects & tasks");
        System.out.println("2. Create task");
        System.out.println("3. Close task");
        System.out.println("4. Close project");
        System.out.println("5. Show employees");
        System.out.println("6. Show personal info");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                agencySystem.getProjects(scanner);
                goBack(scanner);
                break;
            case 2:
                System.out.print("~ Name: ");
                String name = scanner.nextLine();

                System.out.print("~ Referenced project name: ");
                String projectName = scanner.nextLine();

                System.out.print("~ Description: ");
                String description = scanner.nextLine();

                System.out.print("~ Status: ");
                String status = scanner.nextLine();

                System.out.print("~ Deadline (yyyy-mm-dd): ");
                String deadline = scanner.nextLine();

                Task task = new Task(name, projectName, description, status, deadline);

                agencySystem.addTask(task);
                goBack(scanner);

                break;
            case 3:
                System.out.print("~ Enter task's name: ");
                String taskName = scanner.nextLine();
                agencySystem.deleteTask(taskName);
                goBack(scanner);
                break;
            case 4:
                System.out.print("~ Enter project's name: ");
                String closeProjectName = scanner.nextLine();
                agencySystem.closeProject(closeProjectName);
                goBack(scanner);
                break;
            case 5:
                agencySystem.getEmployees();
                goBack(scanner);
                break;
            case 6:
                getProfileInfo();
                goBack(scanner);
                break;
            default:
                System.out.println("❌ Invalid option. Please try again.");
                goBack(scanner);
                break;
        }
    }

    public void updateRole(String newRole) {
        System.out.println("Updating employee role to: " + newRole);
    }
}
