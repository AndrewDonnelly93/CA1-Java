package ca1.secondTask;

public abstract class Exam {
    private int examId;
    private String subject;
    private int duration;

    public Exam(int examId, String subject, int duration) {
        this.examId = examId;
        this.subject = subject;
        this.duration = duration;
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

    public abstract double calculateScore();
}
