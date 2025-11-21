package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.common.CommonGetListRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoursesGetRequest extends CommonGetListRequest {
    private String name;
    private Integer units;
}
