package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OffersGetResponse {
    private List<OfferDto> offers;
    private long total;
}
