package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferEditionRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String courseId;

    @NotBlank
    private String lecturerId;

    @NotNull
    private Integer capacity;
}
