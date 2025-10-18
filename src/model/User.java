package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class User {
    private String username;
    private String password;
    public String role = "";

    private String dbEmployees = "src/data/employees.txt";
    private String dbClients = "src/data/clients.txt";


    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login() {
        try (BufferedReader reader = new BufferedReader(new FileReader(role.equals("employee") ? dbEmployees : dbClients))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 2) continue;

                String email = parts[0];
                String pass = parts[1];

                if (email.equalsIgnoreCase(this.username) && pass.equals(this.password)) {
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

    public abstract void showDashboard(Scanner scanner);

    public void getProfileInfo() {
        System.out.println("Email: " + this.username);
        System.out.println("Role: " + role);

    }
}
