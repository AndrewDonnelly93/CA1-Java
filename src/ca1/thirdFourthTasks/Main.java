package ca1.thirdFourthTasks;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<MultipleChoice> multipleChoicesList = new ArrayList<>();

    private static final ArrayList<Essay> essaysList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Adding and displaying multiple choice exams results

            // Testing the duration exception - uncomment to try it out
//            multipleChoicesList.add(new MultipleChoice(
//                    1, "Literature", 20, 15, 25
//            ));

            // Testing the number of questions exception - uncomment to try it out
//            multipleChoicesList.add(new MultipleChoice(
//                    2, "Math", 60, 30, 70
//            ));

            // Testing for the number of correct answers exception - uncomment to try it out
//            multipleChoicesList.add(new MultipleChoice(
//                    2, "English", 90, -30, 40
//            ));

            multipleChoicesList.add(new MultipleChoice(
                    2, "Chemistry", 45, 30, 50
            ));
            multipleChoicesList.add(new MultipleChoice(
                    3, "Biology", 100, 20, 25
            ));
            displayMultipleChoiceResults();

            // Adding and displaying essays exams results

            // Testing the word limit exception - uncomment to try it out
//            essaysList.add(new Essay(
//                    1, "English", 90,
//                    "aliquam etiam erat velit scelerisque in " +
//                            "dictum non consectetur a erat nam at lectus " +
//                            "urna duis convallis convallis tellus id interdum" +
//                            " velit laoreet id donec ultrices tincidunt arcu" +
//                            " non sodales neque sodales ut etiam sit amet" +
//                            " nisl purus in mollis nunc sed id semper risus" +
//                            " in hendrerit gravida rutrum quisque non tellus" +
//                            " orci ac auctor augue mauris augue neque gravida" +
//                            " in fermentum et sollicitudin ac orci phasellus egestas " +
//                            "tellus rutrum tellus pellentesque eu tincidunt tortor aliquam" +
//                            " nulla facilisi cras fermentum odio eu feugiat pretium nibh" +
//                            " ipsum consequat nisl vel pretium lectus quam id leo in vitae" +
//                            " turpis massa sed elementum",
//                    70, 80, 120
//            ));

            EssayExample essayExampleText = new EssayExample();

            essaysList.add(new Essay(1, "English", 90, essayExampleText.getEssayExample(),
                    70, 80, 500));

            displayEssaysResults();
        } catch (ExamException e) {
            System.out.println(e.toString());
        }
    }

    public static void displayMultipleChoiceResults() {
        System.out.println("-".repeat(50));
        System.out.println("Multiple Choice Results\n");
        for (var item : multipleChoicesList) {
            item.displayExamDetails();
        }
    }

    public static void displayEssaysResults() {
        System.out.println("-".repeat(50));
        System.out.println("Essays Results\n");
        for (var item : essaysList) {
            item.displayExamDetails();
        }
    }


}
