package ca1.tasksFiveToTen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class ExamManagement {
    private static final ArrayList<Student> studentsList = new ArrayList<>();
    private static final ArrayList<Exam> studentExamsList = new ArrayList<>();
    private static ArrayList<ExamResult> examResults = new ArrayList<>();

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

    public static void main(String[] args) {
        EssayExample essayExampleText = new EssayExample();
        try {
            // Exams list - sample data
            studentExamsList.add(new Essay(1, "English", 90, essayExampleText.getEssayExample(),
                    70, 80, 500));
            studentExamsList.add(new MultipleChoice(
                    2, "Chemistry", 45, 30, 50
            ));
            studentExamsList.add(new Essay(3, "Biology", 75, essayExampleText.getEssayExample(),
                    80, 90, 600));
            studentExamsList.add(new MultipleChoice(
                    4, "Math", 60, 40, 45
            ));
            studentExamsList.add(new Essay(5, "History", 55, essayExampleText.getEssayExample(),
                    90, 70, 550));
            studentExamsList.add(new MultipleChoice(
                    6, "Physics", 80, 30, 35
            ));
        } catch (ExamException e) {
            System.out.println(e.toString());
        }

        try {
            // Students List - sample data
            // Testing the student name exception - uncomment to try it out
            // studentsList.add(new Student(2, "J", studentExamsList));
            studentsList.add(
                    new Student(1, "John", studentExamsList)
            );
            studentsList.add(
                    new Student(2, "Alice", studentExamsList)
            );
            studentsList.add(
                    new Student(3, "Paul", studentExamsList)
            );
        } catch (StudentException e) {
            System.out.println(e.toString());
        }

        listStudents();

        Scanner scanner = new Scanner(System.in);

        // Menu-driven system

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Input Exam Result");
            System.out.println("2. Display Exam Results");
            System.out.println("3. Print Results to File");
            System.out.println("4. Quit");

            System.out.println("Choose an option from the menu: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Entering new score
                    System.out.println("Input student name (John/Alice/Paul):");
                    String studentName = scanner.next();
                    System.out.println("Input exam subject (English/Chemistry/Biology/Math/History/Physics):");
                    String examSubject = scanner.next();
                    System.out.println("Input exam score:");
                    String examScore = scanner.next();

                    // Look for student and exam objects;
                    Student student = studentsList.stream().filter(
                            studentObj -> studentObj.getStudentName().equalsIgnoreCase(studentName))
                            .findFirst().orElse(null);

                    Exam exam = studentExamsList.stream().filter(
                            examObj -> examObj.getSubject().equalsIgnoreCase(examSubject))
                            .findFirst().orElse(null);

                    if (student != null && exam != null) {
                        ExamResult result = new ExamResult(student, exam, Integer.parseInt(examScore));
                        examResults.add(result);
                        System.out.println("Exam result has been updated");
                    } else {
                        System.out.println("Error in student name or exam object");
                    }
                    break;

                case 2:
                    // Display exam results
                    Collections.sort(examResults, Collections.reverseOrder());
                    System.out.println("Choose how to sort it: 1. Student Name 2. Exam Subject 3. Score");
                    int sortingField = scanner.nextInt();

                    StringBuilder sortingOutcome = new StringBuilder();
                    sortingOutcome.append("\n")
                            .append(fixedLengthString("Student Name:",15))
                            .append(fixedLengthString("Subject",15))
                            .append(fixedLengthString("Score",5));

                    // Sorting by Student Name
                    if (sortingField == 1) {
                        Collections.sort(examResults, ExamResult.studentNameComparator);

                    // Sorting by exam subject
                    } else if (sortingField == 2) {
                        Collections.sort(examResults, ExamResult.examSubjectComparator);

                    // Sorting by score
                    } else if (sortingField == 3) {
                        Collections.sort(examResults, ExamResult.examScoreComparator);
                    }

                    for (ExamResult result : examResults) {
                        sortingOutcome.append("\n")
                                .append(fixedLengthString(result.getStudent().getStudentName(),15))
                                .append(fixedLengthString(result.getExam().getSubject(),15))
                                .append(fixedLengthString(Integer.toString(result.getScore()),5));
                    }

                    System.out.println(sortingOutcome);
                    break;

                case 3:
                    // Printing exam results to a file
                    String fileName = "C:/College/examResults.txt";
                    StringBuilder examResultsOutcome = new StringBuilder();
                    examResultsOutcome.append("\n")
                            .append(fixedLengthString("Student Name:",15))
                            .append(fixedLengthString("Subject",15))
                            .append(fixedLengthString("Score",5));
                    for (ExamResult result : examResults) {
                        examResultsOutcome.append("\n")
                                .append(fixedLengthString(result.getStudent().getStudentName(),15))
                                .append(fixedLengthString(result.getExam().getSubject(),15))
                                .append(fixedLengthString(Integer.toString(result.getScore()),5));
                    }
                    try {
                        WriteFile data = new WriteFile(fileName, true);
                        data.writeToFile(examResultsOutcome.toString());
                        System.out.println("Exam results have been printed to a file");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Quitting the program. Have a great day");
                    System.exit(0);
                    break;

                default:
                    System.out.println("The option you selected is incorrect. Please enter another option.");
            }
        }
    }

    public static void listStudents() {
        for (var item : studentsList) {
            // Write to a file
            item.printSummaryResult();
            item.printDetailedResults();
        }
    }
}
