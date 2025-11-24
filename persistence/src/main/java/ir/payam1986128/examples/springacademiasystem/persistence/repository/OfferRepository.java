package ir.payam1986128.examples.springacademiasystem.persistence.repository;

import ir.payam1986128.examples.springacademiasystem.persistence.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID>, QuerydslPredicateExecutor<Offer> {

    @Modifying
    @Query("update Offer o set o.registered = o.registered+1 where o.id = :id and o.registered < o.capacity")
    int increaseRegistered(UUID id);

    @Modifying
    @Query("update Offer o set o.registered = o.registered-1 where o.id = :id and o.registered > 0")
    int decreaseRegistered(UUID id);
}
