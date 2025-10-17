package model;

import java.util.Scanner;

public class Client extends User {
    public String clientPhone;

    public Client(String username, String password) {
        super(username, password, "client");
        System.out.println("Client created.");
    }

    @Override
    public void showDashboard(Scanner scanner) {
        System.out.println("1. Show projects");
        System.out.println("2. Show employees");
        System.out.println("3. Show personal info");
        System.out.print("Your choice: ");
    }
    
    public void updateContactInfo(String newPhone) {
        this.clientPhone = newPhone;
        System.out.println("new Phone: " + newPhone);
    }

    public void getClientSummary() {
        System.out.println("Client Summary:");
    }

    public void addProject(Project project) {
        System.out.println("Adding project: ");
    }
    
}
