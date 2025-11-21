package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.common.CommonGetListRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OffersGetRequest extends CommonGetListRequest {
    private String title;
    private String courseId;
    private String semesterId;
    private String lecturerId;
}
