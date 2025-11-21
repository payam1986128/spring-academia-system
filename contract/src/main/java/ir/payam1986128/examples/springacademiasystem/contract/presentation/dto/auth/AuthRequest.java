package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthRequest {

    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 6, max = 20)
    private String password;
}
