import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private List<QuizQuestion> questionBanks;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private Scanner scanner;

    public Quiz(List<QuizQuestion> questions) {
        this.questionBanks = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void start() {
        if (currentQuestionIndex < questionBanks.size()) {
            QuizQuestion currentQuestion = questionBanks.get(currentQuestionIndex);

            // Display questions and options
            System.out.println("Question: " + currentQuestion.getQuestionText());
            List<String> options = currentQuestion.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            // Set up timer for the question
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    displayResultAndMoveToNextQuestion(-1);
                }
            }, 20000);

            // Allow user to select an option
            scanner = new Scanner(System.in);
            int userAnswer = scanner.nextInt() - 1;

            // Stop the timer
            timer.cancel();

            // Check user's answer
            displayResultAndMoveToNextQuestion(userAnswer);
        } else {
            // Display final score and summary
            System.out.println("Quiz completed. Final score: " + score);
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public void displayResultAndMoveToNextQuestion(int userAnswer) {
        QuizQuestion currentQuestion = questionBanks.get(currentQuestionIndex);

        if (userAnswer == currentQuestion.getCorrectAnswerIndex()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " +
                    currentQuestion.getOptions().get(currentQuestion.getCorrectAnswerIndex()));
        }

        currentQuestionIndex++;
        // Move to the next question
        start();
    }
}
