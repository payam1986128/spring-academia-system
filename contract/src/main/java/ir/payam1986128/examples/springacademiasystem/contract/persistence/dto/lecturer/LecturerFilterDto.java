package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.FilterDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturerFilterDto extends FilterDto {
    private String firstName = "";
    private String lastName = "";
}
