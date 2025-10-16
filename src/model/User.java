package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {
    private String username;
    private String password;
    private String dbFilePath = "src/data/users.txt";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean login() {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(dbFilePath))) {
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

    public boolean getUserInfo() {
        return true; // Simplified for 
    }
}