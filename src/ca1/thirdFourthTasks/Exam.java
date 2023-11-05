package ca1.thirdFourthTasks;
// Copied from the secondTask because I implemented another ExamException there
public abstract class Exam {
    private int examId;
    private String subject;
    private int duration;

    public Exam(int examId, String subject, int duration) throws ExamException {
        this.examId = examId;
        this.subject = subject;
        // Duration exception
        if (duration < 30 || duration > 180) {
            System.out.println("duration error");
            throw new ExamException("\n\tDuration should be between 30 and 180 minutes");
        } else {
            this.duration = duration;
        }
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public abstract double calculateScore() throws ExamException;
}
