package internshipProjects;

import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between " + minNumber + " and " + maxNumber + ".");
            System.out.println("You have " + maxAttempts + " attempts.");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts!");
                    score++;
                    guessedCorrectly = true;
                    break;
                }
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, you have reached the maximum number of attempts. The number was " + randomNumber + ".");
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing! Your score is: " + score);
        scanner.close();
    }
}

