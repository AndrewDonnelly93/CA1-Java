package ca1.tasksFiveToTen;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<Student> studentsList = new ArrayList<>();
    private static final ArrayList<Exam> studentExamsList = new ArrayList<>();
    private static final ArrayList<Exam> studentExamsList2 = new ArrayList<>();
    private static final ArrayList<Exam> studentExamsList3 = new ArrayList<>();
    public static void main(String[] args) {
        EssayExample essayExampleText = new EssayExample();
        try {
            studentExamsList.add(new Essay(1, "English", 90, essayExampleText.getEssayExample(),
                    70, 80, 500));
            studentExamsList.add(new MultipleChoice(
                    2, "Chemistry", 45, 30, 50
            ));
            studentExamsList2.add(new Essay(3, "Biology", 75, essayExampleText.getEssayExample(),
                    80, 90, 600));
            studentExamsList2.add(new MultipleChoice(
                    4, "Math", 60, 40, 45
            ));
            studentExamsList3.add(new Essay(5, "History", 55, essayExampleText.getEssayExample(),
                    90, 70, 550));
            studentExamsList3.add(new MultipleChoice(
                    6, "Physics", 80, 30, 35
            ));
        } catch (ExamException e) {
            System.out.println(e.toString());
        }

        try {
            // Testing the student name exception - uncomment to try it out
            // studentsList.add(new Student(2, "J", studentExamsList));
            studentsList.add(new Student(1, "John Smith", studentExamsList));
            studentsList.add(new Student(2, "Alice Magee", studentExamsList2));
            studentsList.add(new Student(3, "Paul Lynch", studentExamsList3));
        } catch (StudentException e) {
            System.out.println(e.toString());
        }

        listStudents();
    }

    public static  void listStudents() {
        for (var item: studentsList) {
            // Write to a file
            item.printSummaryResult();
            item.printDetailedResults();
        }
    }
}
