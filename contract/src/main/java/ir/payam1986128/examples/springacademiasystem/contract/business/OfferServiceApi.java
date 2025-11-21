package ir.payam1986128.examples.springacademiasystem.contract.business;


import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;

public interface OfferServiceApi {
    OfferGetResponse getOffer(String id);

    OffersGetResponse getOffers(OffersGetRequest request);

    OfferCreationResponse create(OfferCreationRequest request);

    void update(String id, OfferEditionRequest request);

    void delete(String id);
}
