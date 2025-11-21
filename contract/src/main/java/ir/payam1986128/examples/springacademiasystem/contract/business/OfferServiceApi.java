package ir.payam1986128.examples.springacademiasystem.contract.business;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterOffersGetResponse;

public interface OfferServiceApi {
    OfferGetResponse getOffer(String id);
    OffersGetResponse getOffers(OffersGetRequest request);
    OfferCreationResponse create(OfferCreationRequest request);
    void update(String id, OfferEditionRequest request);
    void delete(String id);
    CourseOffersGetResponse getOffersByCourse(String id);
    LecturerOffersGetResponse getOffersByLecturer(String id);
    SemesterOffersGetResponse getOffersBySemester();
}
