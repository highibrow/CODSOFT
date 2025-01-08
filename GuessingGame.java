import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        // Initialize the Scanner
        Scanner sc = new Scanner(System.in);
        
        // Points system
        int pts = 0;
        int ptsRecord = 200;
        
        // Initialize the Random Number Generator (Do this once)
        Random random = new Random();

        // Text at beginning
        System.out.println("Welcome to the Guessing Game!");

        while (true) {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            System.out.println("I have selected a number between 1 and 100!");
            
            int attempts = 1;
            while (true) {
                System.out.print("Enter your best guess to my number here: ");
                int firstGuess = sc.nextInt();
                
                // Check if guess is correct
                if (randomNumber == firstGuess) {
                    int tempPts = 20 - attempts;  // Points based on attempts
                    int tempPts1 = tempPts * 3;
                    pts += tempPts1; // Add points to total
                    System.out.println("CONGRATULATIONS! YOU HAVE GUESSED THE NUMBER on your " + attempts + numberEnd(attempts) + " try!");
                    System.out.println("You have a total of " + pts + " pts!");

                    if (pts > ptsRecord) {
                        System.out.println("Congratulations! You have broken the record of " + ptsRecord + " , the new record is now " + pts + "!");
                        ptsRecord = pts; // Update record
                    }
                    break;
                }
                
                // Check if the guess is too low or too high
                if (firstGuess < randomNumber && firstGuess != 333) {
                    System.out.println("Too LOW!");
                    attempts++;
                } else if (firstGuess > randomNumber && firstGuess != 333) {
                    System.out.println("Too BIG!");
                    attempts++;
                }

                // If the user enters 333, reveal the number
                if (firstGuess == 333) {
                    System.out.println("The number was: " + randomNumber);
                    break;
                }
            }

            // Ask if the user wants to continue
            System.out.println("Would you like to continue? (Y or N) ");
            String response = sc.next();
            if (response.equalsIgnoreCase("N")) {
                System.out.println("Thank you for playing!");
                System.out.println("Good Bye!");
                break;
            }
        }
    }

    // Function to handle the suffix for 1st, 2nd, 3rd, etc.
    public static String numberEnd(int i) {
        if (i % 10 == 1 && i != 11) {
            return "st";
        } else if (i % 10 == 2 && i != 12) {
            return "nd";
        } else if (i % 10 == 3 && i != 13) {
            return "rd";
        } else {
            return "th";
        }
    }
}
