package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.mapper.OfferBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.OfferServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterOffersGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfferService implements OfferServiceApi {

    private final OfferDaoApi dao;
    private final OfferBusinessMapper mapper;

    @Override
    public OfferGetResponse getOffer(String id) {
        return null;
    }

    @Override
    public OffersGetResponse getOffers(OffersGetRequest request) {
        return null;
    }

    @Override
    public OfferCreationResponse create(OfferCreationRequest request) {
        return null;
    }

    @Override
    public void update(String id, OfferEditionRequest request) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CourseOffersGetResponse getOffersByCourse(String id) {
        return null;
    }

    @Override
    public LecturerOffersGetResponse getOffersByLecturer(String id) {
        return null;
    }

    @Override
    public SemesterOffersGetResponse getOffersBySemester() {
        return null;
    }
}
