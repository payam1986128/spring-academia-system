package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.OfferBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.OfferServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OffersDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterOffersGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ir.payam1986128.examples.springacademiasystem.business.util.UUIDUtil.parseId;

@Service
@Transactional
@AllArgsConstructor
public class OfferService implements OfferServiceApi {

    private final OfferDaoApi dao;
    private final OfferBusinessMapper mapper;

    @Override
    public OfferGetResponse getOffer(String id) {
        UUID offerId = parseId(id);
        OfferDto offer = getOffer(offerId);
        return mapper.toOfferGetResponse(offer);
    }

    private OfferDto getOffer(UUID id) {
        Optional<OfferDto> optionalOffer = dao.getOffer(id);
        if (optionalOffer.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return optionalOffer.get();
    }

    @Override
    public OffersGetResponse getOffers(OffersGetRequest request) {
        OfferFilterDto filter = mapper.toOfferFilterDto(request);
        OffersDto offers = dao.getOffers(filter);
        return mapper.toOffersGetResponse(offers);
    }

    @Override
    public OfferCreationResponse create(OfferCreationRequest request) {
        OfferDto offer = mapper.toOfferDto(request);
        UUID id = dao.addOffer(offer);
        return new OfferCreationResponse(mapper.toString(id));
    }

    @Override
    public void update(String id, OfferEditionRequest request) {
        UUID offerId = parseId(id);
        OfferDto found = getOffer(offerId);
        mapper.toOfferDto(found, request);
        dao.editOffer(found);
    }

    @Override
    public void delete(String id) {
        UUID offerId = parseId(id);
        OfferDto offer = getOffer(offerId);
        dao.deleteOffer(offer.getId());
    }

    @Override
    public CourseOffersGetResponse getOffersByCourse(String id) {
        OffersDto offers = dao.getOffersByCourse(parseId(id));
        return mapper.toCourseOffersGetResponse(offers);
    }

    @Override
    public LecturerOffersGetResponse getOffersByLecturer(String id) {
        OffersDto offers = dao.getOffersByLecturer(parseId(id));
        return mapper.toLecturerOffersGetResponse(offers);
    }

    @Override
    public SemesterOffersGetResponse getOffersBySemester() {
        OffersDto offers = dao.getOffersByCurrentSemester();
        return mapper.toSemesterOffersGetResponse(offers);
    }
}
