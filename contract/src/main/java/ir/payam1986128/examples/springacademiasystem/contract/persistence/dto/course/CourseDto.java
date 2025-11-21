package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CourseDto {
    private UUID id;
    private String name;
    private int units;
}
