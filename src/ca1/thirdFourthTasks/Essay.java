package ca1.thirdFourthTasks;

public class Essay extends Exam implements Scorable {
    private String essayAnswer;
    private int grammar;
    private int content;
    private int wordLimit;

    public int getWordLimit() {
        return wordLimit;
    }

    public void setWordLimit(int wordLimit) {
        this.wordLimit = wordLimit;
    }

    public String getEssayAnswer() {
        return essayAnswer;
    }

    public void setEssayAnswer(String essayAnswer) {
        this.essayAnswer = essayAnswer;
    }

    public int getGrammar() {
        return grammar;
    }

    public void setGrammar(int grammar) {
        this.grammar = grammar;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Essay(
            int examId, String subject, int duration,
            String essayAnswer, int grammar, int content, int wordLimit
    ) throws ExamException {
        super(examId, subject, duration);
        this.essayAnswer = essayAnswer;
        this.grammar = grammar;
        this.content = content;
        this.wordLimit = wordLimit;
    }

    @Override
    public double calculateScore() throws ExamException {
        return this.gradeEssay();
    }

    private double gradeEssay() throws ExamException {
        // Content gets 60% of overall score
        // Assuming that the score is in percentage out of 100
        double contentScore = this.getContent() * 0.6;
        // Grammar gets 30% of overall score
        // Assuming that the score is in percentage out of 100
        double grammarScore = this.getGrammar() * 0.3;
        // Word count gets 10% of overall score
        double wordCountScore;
        int essayWordCount = essayAnswer.split("\\s").length;

        int upperWordLimit = this.getWordLimit();
        int LOWER_LIMIT = 500;
        int UPPER_LIMIT = 10000;
        // Assuming that the lower word count limit is 100 words fewer
        // than the upper limit or 500 if upperWordLimit is less than 600
        int lowerWordLimit;
        if (upperWordLimit <= LOWER_LIMIT + 100) {
            lowerWordLimit = 500;
        } else {
            lowerWordLimit = this.getWordLimit() - 100;
        }


        // wordLimit exception

        if (
                (upperWordLimit > UPPER_LIMIT || upperWordLimit < LOWER_LIMIT) ||
                        (lowerWordLimit > UPPER_LIMIT || lowerWordLimit < LOWER_LIMIT)
        ) {
            throw new ExamException("\n\tWord Limit should be between 500 and 10000 words");
        }

        // The student gets 10 points if their essay is within the range
        if (essayWordCount >= lowerWordLimit && essayWordCount <= this.getWordLimit()) {
            wordCountScore = 10;
        } else {
        // They get 0 points if their essay is longer or shorter than the range
            wordCountScore = 0;
        }

        // Testing the word count exception below 0 uncomment to try it out
        // essayWordCount = -5;

        // WordCount Exception
        if (essayWordCount <= 0) {
            throw new ExamException("\n\tWord Count should be greater or equal to 0");
        }

        return contentScore + grammarScore + wordCountScore;
    }

    public void displayExamDetails() {
        try {
            double score = calculateScore();
            System.out.println("Essay Exam Result");
            System.out.println("Exam ID: " + this.getExamId());
            System.out.println("Subject: " + this.getSubject());
            System.out.println("Duration: " + this.getDuration() + " minutes");
            System.out.println("Grammar mark: " + this.getGrammar());
            System.out.println("Content mark: " + this.getContent());
            System.out.println("Upper word limit: " + this.getWordLimit());
            System.out.println("You get 60% of your overall score for your content, " +
                    "30% for grammar and 10% for word count");
            System.out.println("Overall Score: " + score + "% out of 100");
            System.out.println("-".repeat(30));
        } catch (ExamException e) {
            System.out.println(e.toString());
        }
    }
}
