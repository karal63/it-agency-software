package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Client extends User {
    public String clientPhone;
    private String dbProjects = "src/data/projects.txt";

    public Client(String username, String password) {
        super(username, password, "client");
        System.out.println("Client created.");
    }

    @Override
    public void showDashboard(Scanner scanner) {
        System.out.println("==================================");
        System.out.println("   Client Dashboard   ");
        System.out.println("==================================");
        System.out.println("Please select an option:");

        System.out.println("1. Create project");
        System.out.println("2. Show employees");
        System.out.println("3. Show profile info");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("~ Enter project name: ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.print("~ Enter project description: ");
                String description = scanner.nextLine();

                Project project = new Project(name, description);

                addProject(project);
                break;
            case 2:
            case 3:
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
    
    public void updateContactInfo(String newPhone) {
        this.clientPhone = newPhone;
        System.out.println("new Phone: " + newPhone);
    }

    public void getClientSummary() {
        System.out.println("Client Summary:");
    }

    public void addProject(Project project) {
        try (FileWriter writer = new FileWriter(dbProjects, true)) {
            String line = project.name + ";" 
                        + project.description + ";" 
                        + project.status + "\n";

            writer.write(line);
            System.out.println("✅ Project added.");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }
    
}
