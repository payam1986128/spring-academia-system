package ir.payam1986128.examples.springacademiasystem.persistence.repository;

import ir.payam1986128.examples.springacademiasystem.persistence.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID>, QuerydslPredicateExecutor<Offer> {

}
