package ir.payam1986128.examples.springacademiasystem.business.exception;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }
}
