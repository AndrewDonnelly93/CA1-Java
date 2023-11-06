package ca1.tasksFiveToTen;

import java.io.IOException;
import java.util.ArrayList;

public class Student implements Printable {
    private int studentId;
    private String studentName;
    private ArrayList<Exam> examsTaken;

    enum ExamType {
        Generic,
        Essay,
        MultipleChoice
    }

    public Student(int studentId, String studentName, ArrayList<Exam> examsTaken)
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

    public ArrayList<Exam> getExamsTaken() {
        return examsTaken;
    }

    public void setExamsTaken(ArrayList<Exam> examsTaken) {
        this.examsTaken = examsTaken;
    }

    public void printStudentDetails() {
        System.out.println("-".repeat(50));
        System.out.println("Student Id: " + studentId);
        System.out.println("Student name: " + studentName);
        System.out.println("Exams taken by this student: ");
    }

    public static String fixedLengthString(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        StringBuilder resultString = new StringBuilder();
        resultString.append(inputString).append(sb);
        return resultString.toString();
    }

    @Override
    public void printSummaryResult() {
        // Write to a file
        String fileName = "C:/College/summaryResult.txt";
        StringBuilder summaryResult = new StringBuilder();
        summaryResult.append("-".repeat(50));

        summaryResult.append("\nStudent ID: ")
                .append(this.getStudentId())
                .append("\t").append("Name: ")
                .append(this.getStudentName()).append("\n");

        summaryResult.append("-".repeat(50));


        for (var exam: this.getExamsTaken()) {
            String score = "0.00";
            try {
                score = exam.calculateScore();
            } catch (ExamException e) {
                System.out.println(e.toString());
            }

            summaryResult.append("\n\n")
                    .append(fixedLengthString("Exam ID:",12))
                    .append(fixedLengthString("Subject",15))
                    .append(fixedLengthString("Score",5));
            summaryResult.append("\n")
                    .append(fixedLengthString(Integer.toString(exam.getExamId()),12))
                    .append(fixedLengthString(exam.getSubject(),15))
                    .append(fixedLengthString(score, 5));

            summaryResult.append("\n");
        }

        try {
            WriteFile data = new WriteFile(fileName, true);
            data.writeToFile(summaryResult.toString());
            System.out.println("Summary results about " + this.getStudentName() + " have been printed to a file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printDetailedResults() {
        // Write to a file
        String fileName = "C:/College/detailedResults.txt";
        StringBuilder detailedResult = new StringBuilder();
        detailedResult.append("-".repeat(50));
        detailedResult.append("\nStudent ID: ").append(this.getStudentId()).append("\t").append("Name: ").append(this.getStudentName()).append("\n");
        detailedResult.append("-".repeat(50));
        for (var exam: this.getExamsTaken()) {
            String score = "0.00";
            try {
                score = exam.calculateScore();
            } catch (ExamException e) {
                System.out.println(e.toString());
            }
            ExamType examType = ExamType.Generic;
            String noCorrect = "";
            if (exam instanceof Essay) {
                examType = ExamType.Essay;
                noCorrect = "N/A";
            } else if (exam instanceof MultipleChoice) {
                examType = ExamType.MultipleChoice;
                noCorrect = Integer.toString(
                        ((MultipleChoice) exam).getCorrectAnswers()
                );
            }
            detailedResult.append("\n")
                    .append(fixedLengthString("Exam ID:",12))
                    .append(fixedLengthString("Subject",15))
                    .append(fixedLengthString("Duration",12))
                    .append(fixedLengthString("Exam Type", 18))
                    .append(fixedLengthString("No Correct", 15))
                    .append(fixedLengthString("Score",5));

            detailedResult.append("\n")
                    .append(fixedLengthString(Integer.toString(exam.getExamId()),12))
                    .append(fixedLengthString(exam.getSubject(), 15))
                    .append(fixedLengthString(Integer.toString(exam.getDuration()), 12))
                    .append(fixedLengthString(examType.name(), 18))
                    .append(fixedLengthString(noCorrect, 15))
                    .append(fixedLengthString(score, 5))
            ;
            detailedResult.append("\n");
        }

        try {
            WriteFile data = new WriteFile(fileName, true);
            data.writeToFile(detailedResult.toString());
            System.out.println("Detailed results about " + this.getStudentName() + " have been printed to a file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}