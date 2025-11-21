package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseGetResponse {
    private String id;
    private String name;
    private int units;
}
