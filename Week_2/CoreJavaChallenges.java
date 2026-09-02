/**
 * Challenges I completed from Revature's "Core Java" presentation
*/
public class CoreJavaChallenges {
    // Runs each challenge
    public static void main(String[] args) {
        helloWorld();
        printingOutput();
        operators();
        controlFlow();
        loops();
        calculator();
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
}
