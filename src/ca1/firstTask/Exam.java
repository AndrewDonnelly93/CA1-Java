package ca1.firstTask;

public class Exam implements Scorable {
    private double score;

    public Exam(double score) throws ExamException {
        if (score < 0 || score > 100) {
            throw new ExamException("\n\tScore should be between 0 and 100");
        } else {
            this.score = score;
        }
    }

    @Override
    public double calculateScore() {;
        return score;
    }
}
