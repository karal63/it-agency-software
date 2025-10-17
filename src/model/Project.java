package model;
public class Project {
    public String name;
    public String description;
    public String status;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = "In Progress";
    }

    public void updateStatus(String newStatus) {
        System.out.println("Updating project status to: " + newStatus);
    }

    public void assignEmployee(Employee employee) {
        System.out.println("Assigning employee to project.");
    }

    public void getProjectSummary() {
        System.out.println("Project Summary:");
    }
}
