package model;
public class Client extends User {
    public String clientPhone;

    public Client(String username, String password) {
        super(username, password);
        System.out.println("Client created.");
    }
    
    public void updateContactInfo(String newPhone) {
        this.clientPhone = newPhone;
        System.out.println("new Phone: " + newPhone);
    }

    public void getClientSummary() {
        System.out.println("Client Summary:");
    }

    public void addProject(Project project) {
        System.out.println("Adding project: ");
    }
    
}
