package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerCreationRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
