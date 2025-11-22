package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OffersDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Offer;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.QOffer;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.OfferPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.OfferRepository;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor
public class OfferDao implements OfferDaoApi {

    private final OfferRepository repository;
    private final OfferPersistenceMapper mapper;

    @Override
    public Optional<OfferDto> getOffer(UUID id) {
        Optional<Offer> optionalOffer = repository.findById(id);
        return optionalOffer.map(mapper::toOfferDto);
    }

    @Override
    public OffersDto getOffers(OfferFilterDto filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage()-1, filter.getPageSize());
        if (filter.getSort() != null && filter.getSortDirection() != null) {
            pageRequest.withSort(Sort.Direction.valueOf(filter.getSortDirection().name()), filter.getSort());
        }
        BooleanExpression predicate = QOffer.offer.title.like("%"+filter.getTitle()+"%");
        if (filter.getCourseId() != null) {
            predicate = predicate.and(QOffer.offer.course.id.eq(filter.getCourseId()));
        }
        if (filter.getLecturerId() != null) {
            predicate = predicate.and(QOffer.offer.lecturer.id.eq(filter.getLecturerId()));
        }
        if (filter.getSemesterId() != null) {
            predicate = predicate.and(QOffer.offer.semester.id.eq(filter.getSemesterId()));
        }
        Page<Offer> offersPage = repository.findAll(predicate, pageRequest);
        return OffersDto.builder()
                .offers(mapper.toOffersDto(offersPage.getContent()))
                .total(offersPage.getTotalElements())
                .build();
    }

    @Override
    public UUID addOffer(OfferDto offerDto) {
        Offer offer = mapper.toOffer(offerDto);
        repository.save(offer);
        return offer.getId();
    }

    @Override
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    public void editOffer(OfferDto offerDto) {
        repository.save(mapper.toOffer(offerDto));
    }

    @Override
    public void deleteOffer(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isOfferExist(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public OffersDto getOffersByCourse(UUID courseId) {
        return getOffersByPredicate(QOffer.offer.course.id.eq(courseId));
    }

    @Override
    public OffersDto getOffersByCurrentSemester() {
        LocalDate currentDate = LocalDate.now();
        return getOffersByPredicate(QOffer.offer.semester.startDate.before(currentDate)
                .and(QOffer.offer.semester.endDate.after(currentDate)));
    }

    @Override
    public OffersDto getOffersByLecturer(UUID lecturerId) {
        return getOffersByPredicate(QOffer.offer.lecturer.id.eq(lecturerId));
    }

    private OffersDto getOffersByPredicate(BooleanExpression predicate) {
        Iterable<Offer> offerIterable = repository.findAll(predicate);
        List<Offer> offers = StreamSupport.stream(offerIterable.spliterator(), false).toList();
        return OffersDto.builder()
                .offers(mapper.toOffersDto(offers))
                .total(offers.size())
                .build();
    }
}
