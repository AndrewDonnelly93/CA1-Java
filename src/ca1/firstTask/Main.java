package ca1.firstTask;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<Exam> examScoresList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            examScoresList.add(new Exam(85));
            examScoresList.add(new Exam(94));

            listExamScores();

        } catch (ExamException e) {
            System.out.println(e.toString());
        }



    }

    public static  void listExamScores() {
        for (var item: examScoresList) {
            double examScore = item.calculateScore();
            System.out.println("Exam Score: " + +examScore);
        }
    }
}
