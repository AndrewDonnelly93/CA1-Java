package ca1.tasksFiveToTen;

public abstract class Exam {
    protected int examId;
    protected String subject;
    protected int duration;

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

    public abstract String calculateScore() throws ExamException;

    public void displayExamDetails() throws ExamException {
        System.out.println("Exam Id: " + this.getExamId()
                + " Subject: " + this.getSubject() +
                " Duration: " + this.getDuration() + " minutes.");
    }
}
