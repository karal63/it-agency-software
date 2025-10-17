package model;
import java.time.LocalDate;

public class Task {
    public String taskName;
    public String taskDescription;
    public String taskStatus;
    public LocalDate deadline;

    public Task() {
        System.out.println("Task created.");
    }

    public void updateStatus(String newStatus) {
        System.out.println("Updating task status to: " + newStatus);
    }

    public void setDeadline(LocalDate deadline) {
        System.out.println("Setting task deadline to: " + deadline);
    }
}
