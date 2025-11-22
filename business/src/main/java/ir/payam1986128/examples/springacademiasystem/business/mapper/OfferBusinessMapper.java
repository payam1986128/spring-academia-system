package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OffersDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterOffersGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfferBusinessMapper extends CommonBusinessMapper {
    OfferGetResponse toOfferGetResponse(OfferDto offer);
    OfferFilterDto toOfferFilterDto(OffersGetRequest offersGetRequest);
    OffersGetResponse toOffersGetResponse(OffersDto offers);
    OfferDto toOfferDto(OfferDto offer);
    List<OfferDto> toOffersDto(List<OfferDto> offersDto);
    OfferDto toOfferDto(OfferCreationRequest offerCreationRequest);
    void toOfferDto(@MappingTarget OfferDto offerDto, OfferEditionRequest offerEditionRequest);
    CourseOffersGetResponse toCourseOffersGetResponse(OffersDto offers);
    LecturerOffersGetResponse toLecturerOffersGetResponse(OffersDto offers);
    SemesterOffersGetResponse toSemesterOffersGetResponse(OffersDto offers);
}
