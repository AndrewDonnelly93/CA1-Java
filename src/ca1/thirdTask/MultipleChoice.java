package ca1.thirdTask;

import ca1.firstTask.Scorable;
import ca1.secondTask.Exam;

public class MultipleChoice extends Exam implements Scorable {
    private int correctAnswers;
    private int noQuestions;

    public MultipleChoice(
            int examId, String subject, int duration, int correctAnswers, int noQuestions
    ) {
        super(examId, subject, duration);
        this.correctAnswers = correctAnswers;
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
    public double calculateScore() {
        return ((double) correctAnswers / noQuestions) * 100;
    }

    public void displayExamDetails() {
        double score = calculateScore();
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
