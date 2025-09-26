public class Client {
    public Client() {
        System.out.println("Client created.");
    }

    public void getClientSummary() {
        System.out.println("Client Summary:");
    }

    public void addProject(Project project) {
        System.out.println("Adding project: ");
    }
    
    public void updateContactInfo(String newEmail, String newPhone) {
        System.out.println("Updating contact info to Email: " + newEmail + ", Phone: " + newPhone);
    }
}
