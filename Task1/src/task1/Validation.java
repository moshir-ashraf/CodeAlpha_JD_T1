/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task1;

/**
 *
 * @author Misho
 */
public class Validation {
    
    static String nameRegex = "[a-zA-Z\\s]+";
    static String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static final int PASSMIN = 8;

    public static boolean validateName(String name) {
        return !name.isBlank() && name.matches(nameRegex);
    }

    public static boolean validateGrade(float grade) {
        return !(grade > 100 || grade < 0);
    }

    public static boolean validateEmail(String email) {
        return !email.isBlank() && email.matches(emailRegex);
    }
    
    public static boolean validatePassword(String password, String name, String email) {
        return !password.isBlank() && password.length() >= PASSMIN && !(password.contains(name) || password.contains(email));
    }
}
