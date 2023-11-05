package ca1.firstTask;

import java.awt.*;

public class ExamException extends Throwable {
    private String errorMessage;

    public ExamException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ExamException() {
        this.errorMessage = "Error in Exam Class";
    }

    public String toString() {
        return String.format("\n\tException: %s", errorMessage);
    }
}
