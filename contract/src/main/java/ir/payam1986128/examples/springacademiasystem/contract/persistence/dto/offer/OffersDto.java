package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OffersDto {
    private List<OfferDto> offers;
    private long total;
}
