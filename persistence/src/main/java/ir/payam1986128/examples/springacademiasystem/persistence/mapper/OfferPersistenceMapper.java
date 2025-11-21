package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Offer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfferPersistenceMapper {
    OfferDto toOfferDto(Offer offer);
    List<OfferDto> toOffersDto(List<Offer> offers);
    Offer toOffer(OfferDto offerDto);
}
