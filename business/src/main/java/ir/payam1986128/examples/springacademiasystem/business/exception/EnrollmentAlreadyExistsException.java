package ir.payam1986128.examples.springacademiasystem.business.exception;

public class EnrollmentAlreadyExistsException extends HandledException {
    public EnrollmentAlreadyExistsException() {
        super("This student has already been enrolled for that offer");
    }
}
