package model;

public class AgencyManagementSystem {
    public AgencyManagementSystem() {
        System.out.println("Agency Management System Initialized.");
    }

    public void addClient(Client client) {
        System.out.println("Adding client: ");
    }

    public void createProject(Client client, Project project) {
        System.out.println("Creating project for client: ");
    }

    public void addEmployee(Employee employee) {
        System.out.println("Adding employee: ");
    }

    public void findProjectById(int projectId) {
        System.out.println("Finding project with ID: " + projectId);
    }

    public void generateReports() {
        // should show active projects and employees attached to certain projects
        System.out.println("Generating reports...");
    }
}
