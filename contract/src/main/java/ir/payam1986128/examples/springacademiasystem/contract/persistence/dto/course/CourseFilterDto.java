package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.FilterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseFilterDto extends FilterDto {
    private String name = "";
    private Integer units;
}
