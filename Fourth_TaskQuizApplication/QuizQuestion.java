import java.util.List;

public class QuizQuestion {

    private String question;
    private List<String> options;
    private int answer;

    public QuizQuestion(String questionText, List<String> options, int correctAnswerIndex) {
        this.question = questionText;
        this.options = options;
        this.answer = correctAnswerIndex;
    }

    public String getQuestionText() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return answer;
    }
}