import java.util.Scanner;

/**
 * September 3, 2026, Word Analyzer Challenge: Write program that analyzes a string provided by the user
*/
public class WordAnalyzer {
    public static void main(String[] args) {
        // User input setup
        Scanner console = new Scanner(System.in);   // User input
        String word;                                // User word

        // Track numbers of:
        int vowelCount = 0;     // Vowels
        int consonantCount = 0; // Consonants
        int digitCount = 0;     // Digits
        int spaceCount = 0;     // Spaces

        // Get word from user
        System.out.print("Enter word: ");
        word = console.nextLine();
        console.close();
        System.out.println();

        // Go through word and tally up counts
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);    // Current character for easy reference

            // Get counts of:
            if (isVowel(character)) vowelCount++;           // Vowels
            if (isConsonant(character)) consonantCount++;   // Consonants
            if (Character.isDigit(character)) digitCount++; // Digits
            if (character == ' ') spaceCount++;             // Spaces
        }

        // Output counts of:
        System.out.println("Characters: " + word.length());     // Characters
        System.out.println("Vowels: " + vowelCount);            // Vowels
        System.out.println("Consonants: " + consonantCount);    // Consonants
        System.out.println("Digits: " + digitCount);            // Digits
        System.out.println("Spaces: " + spaceCount);            // Spaces

        System.out.println();
    }

    // Indicate if character is vowel
    public static boolean isVowel(char character) {
        // We set character lowercase to make comparison easier
        switch(Character.toLowerCase(character)) {
            // Return `true` if character is vowel
            case 'a', 'e', 'i', 'o', 'u':
                return true;
            
            // Return `false` otherwise
            default:
                return false;
        }
    }

    // Indicate if character is consonant
    public static boolean isConsonant(char character) {
        return Character.isLetter(character) && !isVowel(character);
    }
}
