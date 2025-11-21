package ir.payam1986128.examples.springacademiasystem.business.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidRefreshTokenException extends AuthenticationException {

    public InvalidRefreshTokenException() {
        super("Invalid refresh token");
    }
}
