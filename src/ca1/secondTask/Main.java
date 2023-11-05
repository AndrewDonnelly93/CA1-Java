package ca1.secondTask;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<Exam> engExamList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            engExamList.add(new EngExam(1, 60, 70));
            engExamList.add(new EngExam(2, 90, 80));
            engExamList.add(new EngExam(3, 120, 65));

            listEngExams();
        } catch (ExamException e) {
            System.out.println(e.toString());
        }
    }

    public static  void listEngExams() {
        for (var item: engExamList) {
            double examScore = item.calculateScore();
            System.out.println("Exam ID: " + item.getExamId());
            System.out.println("Subject: " + item.getSubject());
            System.out.println("Duration: " + item.getDuration() + " minutes");
            System.out.println("Score: " + +examScore);
            System.out.println("-".repeat(30));
        }
    }
}
