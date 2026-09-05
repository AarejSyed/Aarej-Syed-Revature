import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
CHALLENGE - DATETIMEAPI

Tasks:

1. Write a program that prints:
    1. Today’s date
    2. The current year
    3. The current month
    4. The current day of the month
2. Calculate your Age.
3. Days until your birthday.

Example Inputs/Outputs:

Date: 2026-09-04
Year: 2026
Month: SEPTEMBER
Day: 4

Enter your birth date: 2000-05-15
You are 26 years old.

Enter your birthday: 1998-12-20
Days until your next birthday: 107
*/
public class DateTimeApi {
    public static void main(String[] args) {
        // Set up user input Scanner
        Scanner console = new Scanner(System.in);

        // Get current date
        LocalDate currentDate = LocalDate.now();
        
        // Run tasks:
        printCurrentDate(currentDate);                          // 1: Print current date
        calculateUserAge(console, currentDate);                 // 2: Calculate user age
        calculateDaysUntilUserBirthday(console, currentDate);   // 3: Calculate days until user birthday

        // Close user input Scanner
        console.close();
    }

    // Task 1: Print current date
    public static void printCurrentDate(LocalDate currentDate) {
        // Set up date formatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Print date and its components:
        System.out.println("Date: " + currentDate.format(dateFormatter));   // Formatted date
        System.out.println("Year: " + currentDate.getYear());               // Year
        System.out.println("Month: " + currentDate.getMonth());             // Month
        System.out.println("Day: " + currentDate.getDayOfMonth());          // Day (of month)

        System.out.println();
    }

    // Task 2: Calculate user age
    public static void calculateUserAge(Scanner console, LocalDate currentDate) {
        // Get user birth date
        LocalDate userBirthDate = dateFromUserInput(console, "Enter your birth date: ");

        // Calculate and print user age: years difference between user birth date and current date
        long userAge = ChronoUnit.YEARS.between(userBirthDate, currentDate);
        System.out.println("You are " + userAge + " years old.");

        System.out.println();
    }

    // Task 3: Calculate days until user birthday
    public static void calculateDaysUntilUserBirthday(Scanner console, LocalDate currentDate) {
        // Get user birthday
        LocalDate userBirthday = dateFromUserInput(console, "Enter your birthday: ");

        // Get date of user's current year birthday
        LocalDate userCurrentYearBirthday = userBirthday.withYear(currentDate.getYear());

        // Calculate user's next birthday
        LocalDate userNextBirthday = (
            userCurrentYearBirthday.isAfter(currentDate) ?                          // If user's current year birthday is after current date:
            userCurrentYearBirthday :                                               // It is user's next birthday
            userCurrentYearBirthday.withYear(userCurrentYearBirthday.getYear() + 1) // Otherwise, the birthday after *that* is the user's next birthday
        );

        // Calculate and print days until user's next birthday
        long daysUntilUserNextBirthday = ChronoUnit.DAYS.between(currentDate, userNextBirthday);
        System.out.println("Days until your next birthday: " + daysUntilUserNextBirthday);

        System.out.println();
    }

    // Gets date from user String input of format `yyyy-MM-dd`
    private static LocalDate dateFromUserInput(Scanner console, String prompt) {
        // Print prompt for user
        System.out.print(prompt);

        // Parses user-supplied date and returns corresponding LocalDate
        return LocalDate.parse(console.nextLine());
    }
}
