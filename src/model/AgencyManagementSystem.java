package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgencyManagementSystem {
    private String dbProjects = "src/data/projects.txt";
    private String dbTasks = "src/data/tasks.txt";
    private String dbEmployees = "src/data/employees.txt";
    private String dbClients = "src/data/clients.txt";

    public void addClient(Client client, String contact) {
        try (FileWriter writer = new FileWriter(dbClients, true)) {
            String line = client.getEmail() + ";" + client.getPassword() + ";" + contact + "\n";
            writer.write(line);
            System.out.println("✅ Client added.");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    public void addEmployee(Employee employee, String contact) {
        try (FileWriter writer = new FileWriter(dbEmployees, true)) {
            String line = employee.getEmail() + ";" + employee.getPassword() + ";" + contact + "\n";
            writer.write(line);
            System.out.println("✅ Client added.");
        } catch (IOException e) {
            System.err.println("❌ Error writing to file: " + e.getMessage());
        }
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

    public void closeProject(String projectName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(dbProjects));
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(";");
                String name = parts[0];
                String description = parts[1];

                if (!(name.equalsIgnoreCase(projectName))) {
                    updatedLines.add(line);
                } else {
                    String updatedLine = name + ";" + description + ";" + "Closed";
                    updatedLines.add(updatedLine);
                }
            }
            Files.write(Paths.get(dbProjects), updatedLines);
            System.out.println("🗑️ Project closed.");
        } catch (IOException e) {
            System.err.println("❌ Error deleting task: " + e.getMessage());
        }
        
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

    public void deleteTask(String taskName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(dbTasks));
            List<String> updatedLines = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(";");
                String name = parts[0];
                if (!(name.equalsIgnoreCase(taskName))) {
                    updatedLines.add(line);
                }
            }
            Files.write(Paths.get(dbTasks), updatedLines);
            System.out.println("🗑️ Task deleted.");
        } catch (IOException e) {
            System.err.println("❌ Error deleting task: " + e.getMessage());
        }
    }

    public void getProjects(Scanner scanner) {
        List<String> projects = new ArrayList<>();

        System.out.println("➡️  Redirecting to Projects...");

        System.out.println();
                    
        System.out.println("==================================");
        System.out.println("   All projects   ");
        System.out.println("==================================");

        // Load projects from file
        try (BufferedReader reader = new BufferedReader(new FileReader(dbProjects))) {
            String line;
            int index = 1;
            System.out.println("\n📁 Available Projects:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 1) continue;

                String projectName = parts[0];
                projects.add(projectName);
                System.out.println(index + ". " + projectName);
                index++;
            }

            if (projects.isEmpty()) {
                System.out.println("No projects found.");
                return;
            }

            System.out.print("\nChoose project number to view tasks or press Enter to escape: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("↩️  Returning...");
                return;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Must be a number.");
                return;
            }
            

            if (choice > 0 && choice <= projects.size()) {
                String selectedProject = projects.get(choice - 1);
                System.out.println("\n🧾 Tasks for project: " + selectedProject);
                getTasks(selectedProject);
            } else {
                System.out.println("❌ Invalid selection.");
            }

        } catch (IOException e) {
            System.err.println("Error reading DB file: " + e.getMessage());
        }
    }

    public void getTasks(String projectName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbTasks))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 5) continue;

                String taskName = parts[0];
                String relatedProject = parts[1];
                String taskDesc = parts[2];
                String status = parts[3];
                LocalDate deadline = LocalDate.parse(parts[4]);

                if (relatedProject.equalsIgnoreCase(projectName)) {
                    found = true;
                    System.out.println("──────────────────────────────");
                    System.out.println("Task: " + taskName);
                    System.out.println("Description: " + taskDesc);
                    System.out.println("Status: " + status);
                    System.out.println("Deadline: " + deadline);
                }
            }

            if (!found) {
                System.out.println("No tasks found for project: " + projectName);
            }

        } catch (IOException e) {
            System.err.println("Error reading tasks file: " + e.getMessage());
        }
    }

    public void getEmployees() {
        System.out.println("➡️  Redirecting to Employees list...");

        System.out.println();
                    
        System.out.println("==================================");
        System.out.println("   All employees   ");
        System.out.println("==================================");
                
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

}
