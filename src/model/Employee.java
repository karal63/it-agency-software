package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Employee extends User {
    private String dbEmployees = "src/data/employees.txt";
    private String dbTasks = "src/data/tasks.txt";


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
                goBack(scanner);
                break;
            case 2:
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Referenced project name: ");
                String projectName = scanner.nextLine();

                System.out.print("Description: ");
                String description = scanner.nextLine();

                System.out.print("Status: ");
                String status = scanner.nextLine();

                System.out.print("Deadline (yyyy-mm-dd): ");
                String deadline = scanner.nextLine();

                Task task = new Task(name, projectName, description, status, deadline);

                addTask(task);
                goBack(scanner);

                break;
            case 4:
                System.out.println("➡️  Redirecting to Employees list...");

                System.out.println();
                    
                System.out.println("==================================");
                System.out.println("   All employees   ");
                System.out.println("==================================");
                getEmployees();
                goBack(scanner);
                break;
            case 5:
                System.out.println("➡️  Redirecting to Account...");

                System.out.println();
                    
                System.out.println("==================================");
                System.out.println("   Profile Information   ");
                System.out.println("==================================");
                super.getProfileInfo();
                goBack(scanner);
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
            int index = 1;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                String email = parts[0];
                String contact = parts[2];
                System.out.println(index + ". " + email + " | " + "Contact: " + contact);

                index++;
            }
        } catch (IOException e) {
            System.err.println("Error reading tasks file: " + e.getMessage());
        }
    }

    public void goBack(Scanner scanner) {
        System.out.println();
        System.out.println("Press Enter to go back to dashboard");
        String choice = scanner.nextLine();
        showDashboard(scanner);
    }

    public void addTask(Task task) {
        try (FileWriter writer = new FileWriter(dbTasks, true)) {
            String line = task.name + ";" 
                        + task.projectName + ";"
                        + task.description + ";" 
                        + task.status + ";"
                        + task.deadline + "\n"; 


            writer.write(line);
            System.out.println("✅ Task added.");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    
}
