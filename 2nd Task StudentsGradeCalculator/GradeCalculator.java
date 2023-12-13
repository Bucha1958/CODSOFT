import java.util.Scanner;

public class GradeCalculator {

    private static final Scanner scanner = new Scanner(System.in);
    private static int totalMarks = 0;

    public static void main(String[] args) {
        // Prompt user for the number of subjects
        System.out.print("Number of Subjects done by each student: ");
        int numberOfSubjects = scanner.nextInt();

        // Calculate total marks for all subjects
        calculateTotalMarks(numberOfSubjects);

        // Calculate average marks
        double average = calculateAverage(numberOfSubjects);

        // Calculate grade based on average marks
        char grade = calculateGrade(average);

        // Display results
        System.out.println("Total Marks: " + totalMarks + " | Average: " + average + " | Grade: " + grade);
    }

    // Method to calculate total marks for all subjects
    private static void calculateTotalMarks(int numberOfSubjects) {
        for (int i = 0; i < numberOfSubjects; i++) {
            // Prompt user for each subject's marks
            System.out.print("Grade in subject " + (i + 1) + ": ");
            int subjectMarks = scanner.nextInt();
            totalMarks += subjectMarks;
        }
    }

    // Method to calculate average marks
    private static double calculateAverage(int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    // Method to calculate grade based on average marks
    private static char calculateGrade(double average) {
        if (average >= 80 && average <= 100) {
            return 'A';
        } else if (average >= 70) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
