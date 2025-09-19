package NumberGaming;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;
    
    private static int totalRounds = 0;
    private static int roundsWon = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.\n");
        
        boolean playAgain = true;
        
        while (playAgain) {
            totalRounds++;
            int targetNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + totalRounds + " begins!");
            System.out.println("You have " + attemptsLeft + " attempts remaining.");
            
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess (between " + MIN_NUMBER + " and " + MAX_NUMBER + "): ");
                
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    
                    if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                        System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                        continue;
                    }
                    
                    attemptsLeft--;
                    
                    if (guess == targetNumber) {
                        guessedCorrectly = true;
                        roundsWon++;
                        System.out.println("Congratulations! You guessed the number correctly!");
                        System.out.println("It took you " + (MAX_ATTEMPTS - attemptsLeft) + " attempts.");
                    } else if (guess < targetNumber) {
                        System.out.println("Too low! ");
                    } else {
                        System.out.println("Too high! ");
                    }
                    
                    if (attemptsLeft > 0 && !guessedCorrectly) {
                        System.out.println("You have " + attemptsLeft + " attempts remaining.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts.");
                System.out.println("The number was: " + targetNumber);
            }
            
            System.out.println("\nScore: Rounds won - " + roundsWon + " out of " + totalRounds);
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
            System.out.println();
        }
        
        System.out.println("\nGame Over!");
        System.out.println("Final Score: You won " + roundsWon + " out of " + totalRounds + " rounds.");
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
}