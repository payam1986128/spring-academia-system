package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentEditionRequest {

    private String firstName;

    @NotBlank
    private String lastName;
}
