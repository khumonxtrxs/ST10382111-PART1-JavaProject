/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package khumojavaproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check if username is correctly formatted
    public boolean checkUserName() {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{1,5}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity() {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Method to register user
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            return "Registration successful";
        }
    }

    // Method to verify login
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    // Method to return login status message
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Login successful";
        } else {
            return "Login failed. Username or password incorrect.";
        }
    }
}

/**
 *
 * @author khumo
 */
public class KhumoJavaProject {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // Test registration and login
        Login user = new Login("khum_0", "Khumonxtrxs/_2004", "Khumo", "Twala");
        System.out.println(user.registerUser()); // Should return "Registration successful"
        System.out.println(user.loginUser("khum_0", "Khumonxtrxs/_2004")); // Should return true
        System.out.println(user.returnLoginStatus(true)); // Should return "Login successful"
    }
}

