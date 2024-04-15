/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.myapp.authentication;


import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private String username;
    private String password;

    public LoginTest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUserName() {
        // Implement username validation logic here
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        // Implement password complexity validation logic here
        return password.length() >= 8 && 
               password.matches(".*[A-Z].*") && 
               password.matches(".*\\d.*") && 
               password.matches(".*[^a-zA-Z0-9].*");
    }

    public String registerUser() {
        if (checkUserName() && checkPasswordComplexity()) {
            // Register user logic here
            return "Registration successful";
        } else {
            return "Registration failed";
        }
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        // Implement login logic here
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        return loginSuccess ? "Login successful" : "Login failed";
    }

    // Unit tests
    @Test
    public void testCheckUserName() {
        Login user = new Login("khum_0", "Khumonxtrxs/_2004");
        assertTrue("Username should be valid", user.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login user = new Login("khum_0", "Khumonxtrxs/_2004");
        assertTrue("Password should meet complexity requirements", user.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUser() {
        Login user = new Login("khum_0", "Khumonxtrxs/_2004");
        assertEquals("Registration successful", user.registerUser());
    }

    @Test
    public void testLoginUser() {
        Login user = new Login("khum_0", "Khumonxtrxs/_2004");
        assertTrue("User should be able to login", user.loginUser("khum_0", "Khumonxtrxs/_2004"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login user = new Login("khum_0", "Khumonxtrxs/_2004");
        assertEquals("Login successful", user.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login user = new Login("khum_0", "Khumonxtrxs/_2004");
        assertEquals("Login failed", user.returnLoginStatus(false));
    }
}