package ca1.tasksFiveToTen;

public class StudentException extends Throwable {
    private String errorMessage;

    public StudentException(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public StudentException() {
        this.errorMessage = "Error in Student Class";
    }

    public String toString() {

        return String.format("\n\tException: %s", errorMessage);
    }
}