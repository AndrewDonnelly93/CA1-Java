package ca1.tasksFiveToTen;

import java.util.ArrayList;

public class Student {
    private int studentId;
    private String studentName;
    private ArrayList<MathExam> examsTaken;

    public Student(int studentId, String studentName, ArrayList<MathExam> examsTaken)
            throws StudentException {
        this.studentId = studentId;
        // Student name exception
        if (studentName.length() < 2 || studentName.length() > 30) {
            throw new StudentException("\n\tStudent name should be between 2 and 30 characters");
        }
        this.studentName = studentName;
        this.examsTaken = examsTaken;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<MathExam> getExamsTaken() {
        return examsTaken;
    }

    public void setExamsTaken(ArrayList<MathExam> examsTaken) {
        this.examsTaken = examsTaken;
    }

    public void printStudentDetails() {
        System.out.println("-".repeat(50));
        System.out.println("Student Id: " + studentId);
        System.out.println("Student name: " + studentName);
        System.out.println("Exams taken by this student: ");
    }
}
