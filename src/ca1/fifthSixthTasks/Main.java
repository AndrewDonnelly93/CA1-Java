package ca1.fifthSixthTasks;


import java.util.ArrayList;

public class Main {
    private static final ArrayList<Student> studentsList = new ArrayList<>();
    private static final ArrayList<MathExam> mathExamsList = new ArrayList<>();
    public static void main(String[] args) {
        try {
            mathExamsList.add(new MathExam(1, 90, 90));
            mathExamsList.add(new MathExam(2, 75, 60));
        } catch (ExamException e) {
            System.out.println(e.toString());
        }

        try {
            // Testing the student name exception - uncomment to try it out
            // studentsList.add(new Student(2, "J", mathExamsList));
            studentsList.add(new Student(1, "John Smith", mathExamsList));
        } catch (StudentException e) {
            System.out.println(e.toString());
        }
        listStudents();
    }

    public static  void listStudents() {
        for (var item: studentsList) {
            System.out.println("-".repeat(30));
            item.printStudentDetails();
            for (var exam: item.getExamsTaken()) {
                try {
                    exam.displayMathExamDetails();
                } catch (ExamException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}
