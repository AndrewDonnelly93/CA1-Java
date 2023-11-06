package ca1.tasksFiveToTen;
import java.text.DecimalFormat;

public class MultipleChoice extends Exam implements Scorable {
    private int correctAnswers;
    private int noQuestions;

    public MultipleChoice(
            int examId, String subject, int duration, int correctAnswers, int noQuestions
    ) throws ExamException {
        super(examId, subject, duration);
        // Correct Answers exception
        if (correctAnswers < 0) {
            throw new ExamException("\n\tNumber of correct answers should be greater than or equal to zero");
        }
        this.correctAnswers = correctAnswers;
        // Number of questions exception
        if (noQuestions < 10 || noQuestions > 50) {
            throw new ExamException("\n\tNumber of questions should be between 10 and 50");
        }
        this.noQuestions = noQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getNoQuestions() {
        return noQuestions;
    }

    public void setNoQuestions(int noQuestions) {
        this.noQuestions = noQuestions;
    }

    @Override
    public String calculateScore() {
        DecimalFormat df = new DecimalFormat("0.00");
        double score = ((double) correctAnswers / noQuestions) * 100;
        return df.format(score);
    }

    public void displayExamDetails() {
        String score = calculateScore();
        System.out.println("Multiple Choice Exam Result");
        System.out.println("Exam ID: " + this.getExamId());
        System.out.println("Subject: " + this.getSubject());
        System.out.println("Duration: " + this.getDuration() + " minutes");
        System.out.println("Correct answers: " + this.getCorrectAnswers());
        System.out.println("Number of questions: " + this.getNoQuestions());
        System.out.println("Overall Score: " + score + "% out of 100");
        System.out.println("-".repeat(30));
    }
}
