package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {
    private String username;
    private String password;
    protected String role = "";
    private String dbEmployees = "src/data/employees.txt";
    private String dbClients = "src/data/clients.txt";
    private String dbProjects = "src/data/projects.txt";



    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public boolean login() {
        try (BufferedReader reader = new BufferedReader(new FileReader(role == "employee" ? dbEmployees : dbClients))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                String email = parts[0];
                String password = parts[1];

                if (email.equalsIgnoreCase(this.username) && password.equals(this.password)) {
                    System.out.println("✅ Login successful for " + email);                    
                    return true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading DB file: " + e.getMessage());
        }

        System.out.println("❌ Invalid username or password");
        return false;
    }

    public void getProjects() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dbProjects))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                System.out.println(parts[0]);
            }

        } catch (IOException e) {
            System.err.println("Error reading DB file: " + e.getMessage());
        }
    }

    public boolean getUserInfo() {
        return true; // Simplified for 
    }
}