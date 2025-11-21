package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.common.CommonGetListRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturersGetRequest extends CommonGetListRequest {
    private String firstName;
    private String lastName;
}
