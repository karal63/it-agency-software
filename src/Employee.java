public class Employee {
    public String employeeName;
    public String employeeRole;
    public String employeeEmail;

    public Employee() {
        System.out.println("Employee created.");
    }

    public void assignToProject(Project project) {
        System.out.println("Assigning employee to project: ");
    }

    public void updateRole(String newRole) {
        System.out.println("Updating employee role to: " + newRole);
    }

    public void getEmployeeInfo() {
        System.out.println("Employee Info:");
    }

    public void removeFromProject(Project project) {
        System.out.println("Removing employee from project: ");
    }
}
