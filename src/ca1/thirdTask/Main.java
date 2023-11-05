package ca1.thirdTask;

import java.util.ArrayList;

public class Main {
    private static final ArrayList<MultipleChoice> multipleChoicesList = new ArrayList<>();

    private static final ArrayList<Essay> essaysList = new ArrayList<>();

    public static void main(String[] args) {
        // Adding and displaying multiple choice exams results
        multipleChoicesList.add(new MultipleChoice(
                1, "Literature", 90, 15, 25
        ));
        multipleChoicesList.add(new MultipleChoice(
           2, "Math", 60, 30, 30
        ));
        multipleChoicesList.add(new MultipleChoice(
            3, "Biology", 100, 20, 25
        ));
        displayMultipleChoiceResults();

        // Adding and displaying essays exams results
        essaysList.add(new Essay(
                1, "English", 90,
                "aliquam etiam erat velit scelerisque in " +
                        "dictum non consectetur a erat nam at lectus " +
                        "urna duis convallis convallis tellus id interdum" +
                        " velit laoreet id donec ultrices tincidunt arcu" +
                        " non sodales neque sodales ut etiam sit amet" +
                        " nisl purus in mollis nunc sed id semper risus" +
                        " in hendrerit gravida rutrum quisque non tellus" +
                        " orci ac auctor augue mauris augue neque gravida" +
                        " in fermentum et sollicitudin ac orci phasellus egestas " +
                        "tellus rutrum tellus pellentesque eu tincidunt tortor aliquam" +
                        " nulla facilisi cras fermentum odio eu feugiat pretium nibh" +
                        " ipsum consequat nisl vel pretium lectus quam id leo in vitae" +
                        " turpis massa sed elementum",
                70, 80, 120
        ));
        essaysList.add(new Essay(
                2, "Biology", 60,
                "facilisi morbi tempus iaculis urna id volutpat " +
                        "lacus laoreet non curabitur gravida arcu ac tortor " +
                        "dignissim convallis aenean et tortor at risus viverra adipiscing" +
                        " at in tellus integer feugiat scelerisque varius morbi " +
                        "enim nunc faucibus a pellentesque sit amet porttitor eget " +
                        "dolor morbi non arcu risus quis varius quam quisque",
                80, 90, 90
        ));
        displayEssaysResults();
    }

    public static void displayMultipleChoiceResults() {
        System.out.println("-".repeat(50));
        System.out.println("Multiple Choice Results\n");
        for (var item: multipleChoicesList) {
            item.displayExamDetails();
        }
    }

    public static void displayEssaysResults() {
        System.out.println("-".repeat(50));
        System.out.println("Essays Results\n");
        for (var item: essaysList) {
            item.displayExamDetails();
        }
    }


}
