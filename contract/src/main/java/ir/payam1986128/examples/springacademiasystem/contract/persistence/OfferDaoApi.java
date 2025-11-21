package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OffersDto;

import java.util.Optional;
import java.util.UUID;

public interface OfferDaoApi {
    Optional<OfferDto> getOffer(UUID id);
    OffersDto getOffers(OfferFilterDto filter);
    UUID addOffer(OfferDto offerDto);
    void editOffer(UUID id, OfferDto offerDto);
    void deleteOffer(UUID id);
    boolean isOfferExist(UUID id);
}
