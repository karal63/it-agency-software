package model;
public class Project {
    public String projectName;
    public String projectDescription;
    public String projectStatus;

    // shoud be an array but for simplicity, we use a single Employee reference
    public Employee assignedEmployee;

    public Project() {
        System.out.println("Project created.");
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
