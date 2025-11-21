package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.common;

import ir.payam1986128.examples.springacademiasystem.contract.enumeration.SortDirection;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonGetListRequest {
    @Min(1)
    private int page = 1;
    @Min(1)
    private int pageSize = 10;
    private String sort;
    private SortDirection sortDirection = SortDirection.ASC;
}
