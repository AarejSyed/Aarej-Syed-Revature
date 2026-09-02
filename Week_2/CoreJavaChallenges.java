import java.util.Scanner;

/**
 * Challenges I completed from Revature's "Core Java" presentation
*/
public class CoreJavaChallenges {
    // Runs each challenge
    public static void main(String[] args) {
        // Create console scanner
        Scanner input = new Scanner(System.in);
        
        // Challenges
        helloWorld();
        printingOutput();
        operators();
        controlFlow();
        loops();
        calculator();
        calculateFiveTestScores(input);
        repl(input);

        // Close console scanner
        input.close();
    }

    // Hello World
    private static void helloWorld() {
        System.out.println("CHALLENGE - HELLO WORLD\n");

        System.out.println("Hello World!");

        System.out.println();
    }

    // Printing Output
    private static void printingOutput() {
        System.out.println("CHALLENGE - PRINTING OUTPUT\n");

        int age = 22;
        double height = 5.5;
        String name = "Aarej";

        System.out.printf("Name: %s, Age: %d, Height: %.1f%n", name, age, height);

        System.out.println();
    }

    // Operators
    private static void operators() {
        System.out.println("CHALLENGE - OPERATORS\n");

        int a = 20, b = 10;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));

        boolean a_greater_than_b = a > b;
        boolean a_greater_than_b_and_b_greater_than_zero = a_greater_than_b && (b > 0);

        System.out.println("Is a greater than b? " + a_greater_than_b);
        System.out.println("Is a > b and b > 0? " + a_greater_than_b_and_b_greater_than_zero);

        System.out.println();
    }

    // Control Flow
    private static void controlFlow() {
        System.out.println("CHALLENGE - CONTROL FLOW\n");

        int score = 75;
        char grade;

        if (score < 50) System.out.println("Failed");
        else System.out.println("Passed");

        if (score >= 90) grade = 'A';
        else if (score >= 75) grade = 'B';
        else if (score >= 60) grade = 'C';
        else grade = 'D';

        System.out.println("Grade: " + grade);

        System.out.println();
    }

    // Loops
    private static void loops() {
        System.out.println("CHALLENGE - LOOPS\n");

        System.out.print("For Loop:");
        for (int i = 1; i <= 5; i++) System.out.print(" " + i);
        System.out.println();

        System.out.print("While Loop:");
        int j = 1;
        while (j <= 5) {
            System.out.print(" " + j);
            j++;
        }
        System.out.println();

        System.out.print("Do-While Loop:");
        int k = 1;
        do {
            System.out.print(" " + k);
            k++;
        }
        while (k <= 5);
        System.out.println();

        System.out.println();
    }

    // Calculator
    private static void calculator() {
        System.out.println("CHALLENGE - CALCULATOR\n");

        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";

        while (again.equals("y")) {
            double result;

            if (operator == '+') result = num1 + num2;
            else if (operator == '-') result = num1 - num2;
            else if (operator == '*') result = num1 * num2;
            else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                    result = Double.NaN;
                }
                else {
                    result = num1 / num2;
                }
            }
            else result = Double.NaN;

            System.out.println("Result: " + result);

            again = "n";
        }

        System.out.println("Thank you for using the calculator.");

        System.out.println();
    }

    // Calculate 5 Test Scores
    private static void calculateFiveTestScores(Scanner input) {
        System.out.println("CHALLENGE - CALCULATE 5 TEST SCORES\n");
        
        Integer[] scores = new Integer[5];
        
        System.out.println("Enter your score for each specified test:");

        for(int i = 0; i < scores.length; i++) {
            System.out.print("Test " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }
        System.out.println();

        System.out.print("If the " + scores.length + " test scores entered are: ");
        for(int i = 0; i < scores.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(scores[i]);
        }
        System.out.println('\n');

        int totalScore = 0;
        int minScore = Integer.MAX_VALUE;
        int maxScore = Integer.MIN_VALUE;

        for (int score : scores) {
            totalScore += score;
            if (score < minScore) minScore = score;
            if (score > maxScore) maxScore = score;
        }

        int averageScore = totalScore / scores.length;

        System.out.println("Then:\n");

        System.out.println("Total: " + totalScore);
        System.out.println("Average: " + averageScore);
        System.out.println("Highest: " + maxScore);
        System.out.println("Lowest: " + minScore);
        System.out.println();

        System.out.println("Your values were:");
        for(int i = 0; i < scores.length; i++) {
            char letterGrade;

            if (scores[i] >= 90) letterGrade = 'A';
            else if (scores[i] >= 80) letterGrade = 'B';
            else if (scores[i] >= 70) letterGrade = 'C';
            else if (scores[i] >= 60) letterGrade = 'D';
            else letterGrade = 'F';

            System.out.println(scores[i] + " - " + letterGrade);
        }

        System.out.println();
    }

    // REPL
    private static void repl(Scanner input) {
        System.out.println("CHALLENGE - REPL\n");

        int balance = 0;
        boolean programOpen = true;

        while(programOpen) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println();

            System.out.print("Select command: ");
            int command = input.nextInt();
            System.out.println();

            switch(command) {
                case 1:
                    System.out.println("Balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit (must be non-negative): ");
                    int deposit = input.nextInt();

                    if (deposit < 0) {
                        System.out.println();
                        System.out.println("ERROR: Cannot deposit negative amount.");
                    }
                    else balance += deposit;

                    break;
                case 3:
                    System.out.print("Enter amount to withdraw (must be non-negative and less than or equal to balance): ");
                    int withdrawal = input.nextInt();

                    if (withdrawal < 0) {
                        System.out.println();
                        System.out.println("ERROR: Cannot withdraw negative amount.");
                    }
                    else if (withdrawal > balance) {
                        System.out.println();
                        System.out.println("ERROR: Cannot withdraw amount greater than balance.");
                    }
                    else balance -= withdrawal;

                    break;
                case 4:
                    programOpen = false;

                    break;
                default:
                    System.out.println("ERROR: Not a valid command.");
            }

            if (programOpen) System.out.println();
        }
    }
}
