import java.util.Scanner;

/**
 * September 3, 2026, Password Validator Challenge: Write program that checks if a password meets given requirements
*/
public class PasswordValidator {
    public static void main(String[] args) {
        // User input setup
        Scanner console = new Scanner(System.in);   // User input
        String password;                            // User password

        // Password minimum length
        int minimumLength = 8;
        
        // Password requirement flags
        boolean meetsLengthRequirement = false;
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsNumber = false;

        // Get user password
        System.out.print("Enter password: ");
        password = console.nextLine();
        console.close();
        System.out.println();

        // Check if password meets length requirement
        meetsLengthRequirement = (password.length() >= minimumLength);

        // Check if password meets "character presence" requirements
        for (int i = 0; i < password.length(); i++) {
            // Individual password character
            char character = password.charAt(i);

            // Check uppercase
            if (!containsUppercase && Character.isUpperCase(character)) containsUppercase = true;

            // Check lowercase
            if (!containsLowercase && Character.isLowerCase(character)) containsLowercase = true;

            // Check number
            if (!containsNumber && Character.isDigit(character)) containsNumber = true;
        }

        // Flag password as accepted if it meets all requirements
        boolean accepted = meetsLengthRequirement && containsUppercase && containsLowercase && containsNumber;

        // If password accepted, notify user
        if (accepted) System.out.println("Password accepted!");

        // Otherwise, reject password and tell user why
        else {
            System.out.println("Password rejected:");

            // Unfulfilled requirements:
            if (!meetsLengthRequirement) System.out.println("- Must be at least 8 characters long");    // Does not meet or excede minimum length
            if (!containsUppercase) System.out.println("- Must contain an uppercase letter");           // Does not contain an uppercase letter
            if (!containsLowercase) System.out.println("- Must contain a lowercase letter");            // Does not contain a lowercase letter
            if (!containsNumber) System.out.println("- Must contain a number");                         // Does not contain number
        }

        System.out.println();
    }
}
