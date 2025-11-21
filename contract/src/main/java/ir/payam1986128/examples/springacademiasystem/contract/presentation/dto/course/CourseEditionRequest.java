package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseEditionRequest {

    @NotBlank
    private String name;

    @NotBlank
    private Integer units;
}
