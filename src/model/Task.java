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

    public void assignEmployee(Employee employee) {
        System.out.println("Assigning employee to task.");
    }

    public void setDeadline(LocalDate deadline) {
        System.out.println("Setting task deadline to: " + deadline);
    }

    public void getTaskDetails() {
        System.out.println("Task Details:");
    }
}
