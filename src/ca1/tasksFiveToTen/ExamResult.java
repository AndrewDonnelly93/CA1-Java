package ca1.tasksFiveToTen;
import java.util.Comparator;
public class ExamResult implements Comparable<ExamResult> {
    private Student student;
    private Exam exam;
    // I used double here because initially I stored score with a double type
    private int score;

    public ExamResult(Student student, Exam exam, int score) {
        this.student = student;
        this.exam = exam;
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(ExamResult anotherResult) {
        return Double.compare(this.score, anotherResult.score);
    }

    public static Comparator<ExamResult> studentNameComparator = Comparator.comparing(
            examResult -> examResult.student.getStudentName()
    );

    public static Comparator<ExamResult> examSubjectComparator = Comparator.comparing(
            examResult -> examResult.exam.getSubject()
    );

    public static Comparator<ExamResult> examScoreComparator = Comparator.comparing(
            ExamResult::getScore
    );
}
