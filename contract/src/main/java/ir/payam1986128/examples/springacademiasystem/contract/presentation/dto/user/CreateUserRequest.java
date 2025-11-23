package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user;

import ir.payam1986128.examples.springacademiasystem.contract.enumeration.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    @Size(min = 3, max = 20)
    private String username;

    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    private Role role;

    private String studentNumber;
}
