package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgencyManagementSystem {
    private String dbProjects = "src/data/projects.txt";
    private String dbTasks = "src/data/tasks.txt";
    private String dbEmployees = "src/data/employees.txt";


    public AgencyManagementSystem() {
        System.out.println("Agency Management System Initialized.");
    }

    public void addClient(Client client) {
        System.out.println("Adding client: ");
    }

    public void addEmployee(Employee employee) {
        System.out.println("Adding employee: ");
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

    public void getProjects(Scanner scanner) {
        List<String> projects = new ArrayList<>();

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

            System.out.print("\nChoose project number to view tasks: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

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
