import java.util.Scanner;
import java.util.Random;

/**
 * September 3, 2026, REPL App Challenge: Create REPL App implementing various commands
*/
public class ReplApp {
    public static void main(String[] args) {
        // Setup
        boolean programActive = true;               // "Program active" flag
        Scanner console = new Scanner(System.in);   // Create console scanner
        Random random = new Random();               // Create random number generator
        String command;                             // Command given by user
        
        // Greet user
        System.out.println("Welcome to my REPL App!");
        System.out.println();

        // Program loop: runs only when `programActive` is `true`
        while(programActive) {
            // Get user command
            command = console.nextLine();
            System.out.println();
            
            // Execute user command:
            switch(command) {
                // "help"
                case "help":
                    help();
                    break;

                // "add"
                case "add":
                    add(console);
                    break;

                // "subtract"
                case "subtract":
                    subtract(console);
                    break;

                // "multiply"
                case "multiply":
                    multiply(console);
                    break;

                // "divide"
                case "divide":
                    divide(console);
                    break;

                // "random"
                case "random":
                    random(console, random);
                    break;

                // "reverse"
                case "reverse":
                    reverse(console);
                    break;

                // "quit"
                case "quit":
                    // Notify user of program deactivation and set `programActive` to `false`, ending program loop
                    System.out.println("Goodbye!");
                    programActive = false;
                    break;

                // Invalid command
                default:
                    // Notify user of command invalidity and display help output
                    System.out.println("ERROR: Command not recognized.");
                    System.out.println();
                    help();
            }

            System.out.println();
        }

        // Close console scanner
        console.close();
    }

    // Help
    private static void help() {
        // Print list of available commands
        System.out.println("""
            Available commands:
                add
                subtract
                multiply
                divide
                random
                reverse
                quit""");
    }

    // Add
    private static void add(Scanner input) {
        // Get addends
        System.out.print("First number: ");
        int addend1 = readIntegerLine(input);
        System.out.print("Second number: ");
        int addend2 = readIntegerLine(input);

        // Calculate and print sum
        int sum = addend1 + addend2;
        System.out.println("Result: " + sum);
    }

    // Subtract
    private static void subtract(Scanner input) {
        // Get minuend and subtrahend
        System.out.print("First number: ");
        int minuend = readIntegerLine(input);
        System.out.print("Second number: ");
        int subtrahend = readIntegerLine(input);

        // Calculate and print difference
        int difference = minuend - subtrahend;
        System.out.println("Result: " + difference);
    }

    // Multiply
    private static void multiply(Scanner input) {
        // Get factors
        System.out.print("First number: ");
        int factor1 = readIntegerLine(input);
        System.out.print("Second number: ");
        int factor2 = readIntegerLine(input);

        // Calculate and print product
        int product = factor1 * factor2;
        System.out.println("Result: " + product);
    }

    // Divide
    private static void divide(Scanner input) {
        // Get dividend and divisor
        System.out.print("First number: ");
        int dividend = readIntegerLine(input);
        System.out.print("Second number: ");
        int divisor = readIntegerLine(input);

        // Display error if divisor is 0
        if (divisor == 0) System.out.println("ERROR: Cannot divide by zero.");

        // Otherwise, calculate and print quotient
        else {
            int quotient = dividend / divisor;
            System.out.println("Result: " + quotient);
        }
    }

    // Random
    private static void random(Scanner input, Random random) {
        // Get minimum and maximum of RNG range
        System.out.print("Minimum: ");
        int minimum = readIntegerLine(input);
        System.out.print("Maximum: ");
        int maximum = readIntegerLine(input);

        // Calculate and print random number constrainted between specified minimum and maximum (both inclusive)
        int randomNumber = random.nextInt(maximum - minimum + 1) + minimum;
        System.out.println("Random number: " + randomNumber);
    }

    // Reverse
    private static void reverse(Scanner input) {
        // Get string to reverse
        System.out.print("Enter text: ");
        String originalString = input.nextLine();

        // Reverse string and print
        String reversedString = (new StringBuilder(originalString)).reverse().toString();
        System.out.println(reversedString);
    }

    // Read newline-delimited integers without leaving trailing newline
    private static int readIntegerLine(Scanner input) {
        int integer = input.nextInt();  // Get input integer
        input.nextLine();               // Consume trailing newline
        return integer;                 // Return input integer
    }
}
