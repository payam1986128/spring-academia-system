package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SemesterOfferDto {
    private String id;
    private String title;
    private String courseId;
    private String lecturerId;
    private int capacity;
    private int registered;
}
