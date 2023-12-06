import java.util.Random;
import java.util.*;

class RunMyGame {
    public static void main(String[] args) {

        // Initialize random number generator and scanner
        Random random = new Random();
        Scanner scn = new Scanner(System.in);

        // Generate a random number between 1 and 100 (inclusive)
        int randomNumber = random.nextInt(100) + 1;
        System.out.println(randomNumber);

        // Start an infinite loop for playing the game
        while (true) {
            // Prompt the user to play again or exit
            System.out.print("Play again? Enter 'y' to continue or 'n' to exit: ");
            
           
            char enterYesOrNo = '\u0000';
            try {
                String userInput = scn.nextLine().trim(); // Trim to remove leading/trailing whitespaces
                if (userInput.length() == 1 && (userInput.charAt(0) == 'y' || userInput.charAt(0) == 'n')) {
                    enterYesOrNo = userInput.charAt(0);
                } else {
                    throw new InputMismatchException("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter 'y' or 'n'");
                scn.nextLine(); // Consume the entire line to discard the invalid input
                continue;
            }
            
            if (enterYesOrNo == 'y') {
                // Allow five attempts
                for (int i = 5; i > 0; i--) {
                    if (i == 5) {
                        System.out.println("You have maximum " + i + " attempts");
                    } else if (i < 5 && i > 1) {
                        System.out.println(i + " attempts");
                    } else {
                        System.out.println("Final attempt");
                    }

                    System.out.print("Enter a Number: ");

                    int guessNumber;
                    try {
                        guessNumber = scn.nextInt();
                    } catch (Exception ex) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scn.nextLine(); // Consume the entire line to discard the invalid input
                        i++; // Increment i to account for invalid attempt
                        continue; // Continue the loop to prompt the user again
                    }

                    // Compare the user's guess with the random number
                    if (randomNumber < guessNumber) {
                        System.out.println("Too high");
                    } else if (randomNumber > guessNumber) {
                        System.out.println("Too low");
                    } else {
                        System.out.println("You guessed it correctly! Keep it up!");
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }
}
