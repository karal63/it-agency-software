package model;
import java.time.LocalDate;

public class Task {
    public String name;
    public String projectName;
    public String description;
    public String status;
    public String deadline;

    public Task(String name, String projectName, String description, String status, String deadline) {
        this.name = name;
        this.projectName = projectName;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }

    public void updateStatus(String newStatus) {
        System.out.println("Updating task status to: " + newStatus);
    }

    public void setDeadline(LocalDate deadline) {
        System.out.println("Setting task deadline to: " + deadline);
    }
}
