package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OfferDto {
    private UUID id;
    private String title;
    private CourseDto course;
    private LecturerDto lecturer;
    private SemesterDto semester;
    private int capacity;
    private int registered;
    private int version;

    public void increaseRegistered() {
        this.registered++;
    }

    public void decreaseRegistered() {
        this.registered--;
    }
}
