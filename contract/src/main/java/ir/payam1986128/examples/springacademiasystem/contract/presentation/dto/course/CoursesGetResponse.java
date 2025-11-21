package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoursesGetResponse {
    private List<CourseDto> courses;
    private long total;
}
