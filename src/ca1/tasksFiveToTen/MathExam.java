package ca1.tasksFiveToTen;

public class MathExam extends Exam {
    private int score;

    public MathExam(int examId, int duration, int score) throws ExamException {
        super(examId, "Math", duration);
        this.score = score;
    }

    @Override
    public double calculateScore() throws ExamException {
        return score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void displayMathExamDetails() throws ExamException {
        System.out.println("-".repeat(30));
        this.displayExamDetails();
        System.out.println("Score: " + this.getScore());
        System.out.println("-".repeat(30));
    }
}
