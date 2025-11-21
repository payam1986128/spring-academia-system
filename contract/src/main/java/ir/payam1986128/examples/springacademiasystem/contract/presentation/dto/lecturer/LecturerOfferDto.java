package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerOfferDto {
    private String id;
    private String title;
    private String courseId;
    private int capacity;
    private int registered;
}
