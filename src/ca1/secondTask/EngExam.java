package ca1.secondTask;

// Concrete class extending abstract Exam class
public class EngExam extends Exam {
    private double score;
    public EngExam(
            int examId, int duration, double score
    ) throws ExamException {
        super(examId, "English", duration);
        if (score < 0 || score > 100) {
            throw new ExamException("\n\tScore should be between 0 and 100");
        } else {
            this.score = score;
        }
    }

    @Override
    public double calculateScore() {
        return this.score;
    }
}
