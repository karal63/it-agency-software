package model;

import java.util.Scanner;

public class Client extends User {
    public String clientPhone;
    private AgencyManagementSystem agencySystem = new AgencyManagementSystem();

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
        System.out.println("3. Show projects & tasks");
        System.out.println("4. Show profile info");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("~ Enter project name: ");
                scanner.nextLine();
                String name = scanner.nextLine();

                System.out.print("~ Enter project description: ");
                String description = scanner.nextLine();

                Project project = new Project(name, description);

                agencySystem.addProject(project);
                goBack(scanner);
                break;
            case 2: 
                agencySystem.getEmployees();
                goBack(scanner);
                break;
            case 3:
                agencySystem.getProjects(scanner);
                goBack(scanner);
                break;
            case 4:
                getProfileInfo();
                goBack(scanner);
                break;        
            default:
                System.out.println("❌ Invalid option. Please try again.");
                goBack(scanner);
                break;
        }
    }
    
    public void updateContactInfo(String newPhone) {
        this.clientPhone = newPhone;
        System.out.println("new Phone: " + newPhone);
    }
}
