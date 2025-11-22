package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.FilterDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OfferFilterDto extends FilterDto {
    private String title = "";
    private UUID courseId;
    private UUID lecturerId;
    private UUID semesterId;
}
