package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SemesterOffersGetResponse {
    private List<SemesterOfferDto> offers;
}
