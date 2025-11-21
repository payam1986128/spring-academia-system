package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.OfferPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OfferDao implements OfferDaoApi {

    private final OfferRepository repository;
    private final OfferPersistenceMapper mapper;
}
