package model;

import java.io.FileWriter;
import java.io.IOException;

public class AgencyManagementSystem {
    private String dbProjects = "src/data/projects.txt";

    public AgencyManagementSystem() {
        System.out.println("Agency Management System Initialized.");
    }

    public void addClient(Client client) {
        System.out.println("Adding client: ");
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

    public void addEmployee(Employee employee) {
        System.out.println("Adding employee: ");
    }
}
