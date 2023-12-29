import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // Create quiz questions
        QuizQuestion question1 = new QuizQuestion(
                "What is the latest long-term support (LTS) version of Java?",
                List.of("Java 8", "Java 11", "Java 14", "Java 17"), 3);

        QuizQuestion question2 = new QuizQuestion(
                "Which keyword is used to define a constant in Java?",
                List.of("var", "final", "const", "static"), 1);

        QuizQuestion question3 = new QuizQuestion(
                "What is the purpose of the 'super' keyword in Java?",
                List.of("Access the superclass constructor", "Access the subclass constructor", "Refer to a static variable", "Call a method on the current object"), 0);

        QuizQuestion question4 = new QuizQuestion(
                "Which interface is used for basic exception handling in Java?",
                List.of("Exception", "Throwable", "Error", "RuntimeException"), 1);

        QuizQuestion question5 = new QuizQuestion(
                "What is the default value of a local variable in Java?",
                List.of("0", "null", "false", "Depends on the variable type"), 3);

        QuizQuestion question6 = new QuizQuestion(
                "What is the purpose of the 'this' keyword in Java?",
                List.of("Refer to the current class", "Refer to the superclass", "Allocate memory for an object", "Access a static method"), 0);

        QuizQuestion question7 = new QuizQuestion(
                "Which collection class is synchronized in Java?",
                List.of("ArrayList", "LinkedList", "Vector", "HashSet"), 2);

        QuizQuestion question8 = new QuizQuestion(
                "In Java, what is the purpose of the 'static' keyword?",
                List.of("Create a constant variable", "Allocate memory for an object", "Define a class method", "Specify access permissions"), 2);

        QuizQuestion question9 = new QuizQuestion(
                "What is the output of the following code?\n" +
                        "```java\n" +
                        "int x = 5;\n" +
                        "System.out.println(x++);\n" +
                        "```",
                List.of("5", "6", "4", "Compilation error"), 0);

        QuizQuestion question10 = new QuizQuestion(
                "Which design principle in Java suggests that a class should have only one reason to change?",
                List.of("Encapsulation", "Inheritance", "Polymorphism", "Single Responsibility Principle"), 3);

        // Create a quiz
        Quiz quiz = new Quiz(List.of(
                question1, question2, question3, question4, question5,
                question6, question7, question8, question9, question10));

        // Start the quiz
        quiz.start();
    }
} 