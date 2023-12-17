import java.util.InputMismatchException;
import java.util.Scanner;


public class AtmMachine {
    private static final Scanner scanner = new Scanner(System.in);
    
        
    private static double balance;
    private UserAccount user;

    public AtmMachine(double initialBalance) {
        this.user = new UserAccount(initialBalance);
        balance = user.getBalance();
    }
    
    // Method that withdraws money from customers account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw sucessful");
        } else {
            System.out.println("Insufficient balance...");
        }
    }

    // Method that deposit money to customers account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully");
        } else {
            System.out.println("Invalid");
        }
    }

    // it checks the balance in customer's account
    public void checkBalance() {
        System.out.println("Your balance is " + balance);
    }

    // method that stop the execution thread
    public void exit() {
        System.out.println("Exiting. Thank you!");
        scanner.close();
        System.exit(0);
    }

    // input method it accepts your choice of transaction
    public void input() {
       
        System.out.println("Withdraw press 1: ");
        System.out.println();
        System.out.println("Deposit press 2: ");
        System.out.println();
        System.out.println("Check your balance press 3: ");
        System.out.println();
        System.out.println("Exit press 4: ");
        System.out.println();

        System.out.print("Select your options: ");
        int options = scanner.nextInt();
        double amount;
        if (options == 1) {
            System.out.print("Enter withdrawal amount: ");
            amount = scanner.nextDouble();
            withdraw(amount);
        } else if (options == 2) {
            System.out.print("Enter deposit amount: ");
            amount = scanner.nextDouble();
            deposit(amount);
        } else if (options == 3) {
            checkBalance();
        } else {
            exit();
        }
    }

    // Method to get a single character input from the user, handling invalid input
    public char getUserInputChar() {
        while (true) {
            try {
                String userInput = scanner.next().trim();
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
    
    public static void main(String[] args) {
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        AtmMachine atm = new AtmMachine(initialBalance);
        

        while (true) {
            // Play the game
            atm.input();
            // Prompt the user to play again or exit
            System.out.print("Perform another transaction? Enter 'y' to continue or 'n' to exit: ");
            char enterYesOrNo = atm.getUserInputChar();

            // Check user's choice to continue or exit
            if (enterYesOrNo == 'n') {
                atm.exit();
            }
        }
    }
}
