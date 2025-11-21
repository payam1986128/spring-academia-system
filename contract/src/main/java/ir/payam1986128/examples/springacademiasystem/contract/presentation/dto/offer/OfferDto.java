package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDto {
    private String id;
    private String title;
    private String courseId;
    private String semesterId;
    private String lecturerId;
    private int capacity;
    private int registered;
}
