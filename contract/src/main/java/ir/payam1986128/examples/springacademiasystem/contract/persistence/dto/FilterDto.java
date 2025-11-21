package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto;

import ir.payam1986128.examples.springacademiasystem.contract.enumeration.SortDirection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDto {
    private int page;
    private int pageSize;
    private String sort;
    private SortDirection sortDirection;
}
