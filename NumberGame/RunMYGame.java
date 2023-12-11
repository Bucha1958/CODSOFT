import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class RunMyGame {

    private static final Scanner scn = new Scanner(System.in);
    private static String userName = "";
    private static int score = 0;
    private static int randomNumber;

    private static final int MAX_ATTEMPTS = 5;
    private static final int HINT_RANGE = 10;

    public static void main(String[] args) {
        System.out.println("I am here to Entertain you");
        System.out.println();

        // Get user information (name) and set up the initial game
        getUserInfo();

        // Start an infinite loop for playing the game
        while (true) {
            // Play the game
            playGame();

            // Prompt the user to play again or exit
            System.out.print("Play again? Enter 'y' to continue or 'n' to exit: ");
            char enterYesOrNo = getUserInputChar();

            // Check user's choice to continue playing or exit
            if (enterYesOrNo == 'n') {
                break;
            }
        }

        // Close the Scanner when it's no longer needed
        scn.close();
    }

    // Method to get user information (name) and set up the initial game
    private static void getUserInfo() {
        if (userName.trim().isEmpty()) {
            System.out.println("May I know your name: ");
            userName = scn.nextLine().trim();

            if (userName.isEmpty()) {
                System.out.println("Please provide a valid name.");
                System.exit(0);
            } else {
                System.out.println(userName + " welcome to Guessing Game");
                System.out.println();
            }
        }
    }

    // Method to handle the game logic
    private static void playGame() {
        // Initialize random number generator
        Random random = new Random();
        // Generate a random number between 1 and 100 (inclusive)
        randomNumber = random.nextInt(100) + 1;
        System.out.println(randomNumber);

        // Loop through the attempts
        for (int attempts = MAX_ATTEMPTS; attempts > 0; attempts--) {
            // Display information about the attempts
            displayAttemptsMessage(attempts);

            // Get the user's guess
            int guessNumber = getUserGuess();

            // Compare the user's guess with the random number
            if (randomNumber < guessNumber) {
                System.out.println("Too high");
            } else if (randomNumber > guessNumber) {
                System.out.println("Too low");
            } else {
                // User guessed correctly
                score++;
                System.out.println("You guessed it correctly! " + userName + ", your score is " + score + " Keep it up!");
                return; // Exit the method after a correct guess
            }
        }
        // Out of attempts, display the correct number
        System.out.println("Out of attempts. The correct number was: " + randomNumber);
    }

    // Method to display messages about the attempts
    private static void displayAttemptsMessage(int attempts) {
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("You have maximum " + attempts + " attempts");
        } else if (attempts == 3) {
            System.out.println(attempts + " attempts");
        } else if (attempts == 2) {
            // Provide a hint for the range of the correct number
            int lowerbound = randomNumber - HINT_RANGE;
            int upperbound = randomNumber + 5;
            System.out.println(attempts + " attempts but I will give you a hint: the target number is between " + lowerbound + " and " + upperbound);
        } else if (attempts == 1) {
            System.out.println("Final attempt");
        }
    }

    // Method to get the user's guess, handling invalid input
    private static int getUserGuess() {
        while (true) {
            System.out.print("Enter a Number: ");

            try {
                int guessNumber = scn.nextInt();
                scn.nextLine(); // Consume the newline character
                return guessNumber;
            } catch (InputMismatchException ex) {
                // Handle invalid input (non-integer)
                System.out.println("Invalid input. Please enter a valid number.");
                scn.nextLine(); // Consume the entire line to discard the invalid input
            }
        }
    }

    // Method to get a single character input from the user, handling invalid input
    private static char getUserInputChar() {
        while (true) {
            try {
                String userInput = scn.nextLine().trim();
                if (userInput.length() == 1 && (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'n')) {
                    return userInput.charAt(0);
                } else {
                    throw new InputMismatchException("Invalid input");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input (not 'y' or 'n')
                System.out.println("Invalid input.");
                System.out.println();
            }
        }
    }
}
