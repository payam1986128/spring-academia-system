package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseOfferDto {
    private String id;
    private String title;
    private String lecturerId;
    private int capacity;
    private int registered;
}
