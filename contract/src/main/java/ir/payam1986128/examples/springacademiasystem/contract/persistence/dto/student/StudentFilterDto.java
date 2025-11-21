package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.FilterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentFilterDto extends FilterDto {
    private String firstName;
    private String lastName;
    private String studentNumber;
}
