package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferGetResponse {
    private String id;
    private String title;
    private CourseDto course;
    private SemesterDto semester;
    private LecturerDto lecturer;
    private int capacity;
    private int registered;
    private int version;
}
