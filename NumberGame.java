import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int randomNumber = generateRandomNumber(minRange, maxRange, random);
            int attempts = playGame(minRange, maxRange, maxAttempts, randomNumber, scanner);

            if (attempts > 0) {
                totalAttempts += attempts;
                roundsWon++;
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

        } while (playAgain(scanner));

        System.out.println("\nGame Over! Rounds won: " + roundsWon + " | Total attempts: " + totalAttempts);
        scanner.close();
    }

    private static int generateRandomNumber(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    private static int playGame(int min, int max, int maxAttempts, int randomNumber, Scanner scanner) {
        System.out.println("\nNew Round: Guess the number between " + min + " and " + max);

        int attempts = 0;
        boolean guessedCorrectly = false;

        do {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                guessedCorrectly = true;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

        } while (!guessedCorrectly && attempts < maxAttempts);

        System.out.println("Round Summary: Attempts taken: " + attempts);
        return guessedCorrectly ? attempts : -1;
    }

    private static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgainInput = scanner.next().toLowerCase();
        return playAgainInput.equals("yes");
    }
}
