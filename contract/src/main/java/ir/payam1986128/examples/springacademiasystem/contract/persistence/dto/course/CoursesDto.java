package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CoursesDto {
    private List<CourseDto> courses;
    private long total;
}
