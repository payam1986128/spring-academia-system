package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private Integer capacity;
}
