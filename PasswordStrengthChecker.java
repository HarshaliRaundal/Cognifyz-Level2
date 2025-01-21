/*Create a program that checks the strength of a password. Prompt the user to input a password and analyze its strength based on certain criteria, such as length, presence of uppercase letters, lowercase letters, numbers, and special characters. 
Provide feedback on the password strength.*/

import java.util.*;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to enter a password
        System.out.println("Enter a password: ");
        String password = sc.nextLine();

        // Check the strength of the password
        String strength = checkPasswordStrength(password);

        // Display the password strength
        System.out.println("Password strength: " + strength);

        sc.close();
    }

    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        // Determine the strength of the password
        if (length >= 8 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            return "Strong";
        } else if (length >= 6 && ((hasUppercase && hasLowercase) || (hasNumber && hasSpecialChar))) {
            return "Medium";
        } else {
            return "Weak";
        }
    }
}
