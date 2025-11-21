package ir.payam1986128.examples.springacademiasystem.business.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotFoundException extends AuthenticationException {
    public UserNotFoundException() {
        super("User not found");
    }
}
