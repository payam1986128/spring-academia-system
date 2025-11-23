package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OffersDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseOfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.CourseOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerOfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerOffersGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterOfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterOffersGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OfferBusinessMapper extends CommonBusinessMapper {
    OfferGetResponse toOfferGetResponse(OfferDto offer);
    OfferFilterDto toOfferFilterDto(OffersGetRequest offersGetRequest);
    OffersGetResponse toOffersGetResponse(OffersDto offers);
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "lecturerId", source = "lecturer.id")
    @Mapping(target = "semesterId", source = "semester.id")
    ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.OfferDto toOfferDto(OfferDto offer);
    @Mapping(target = "course.id", source = "courseId")
    @Mapping(target = "lecturer.id", source = "lecturerId")
    OfferDto toOfferDto(OfferCreationRequest offerCreationRequest);
    @Mapping(target = "course.id", source = "courseId")
    @Mapping(target = "lecturer.id", source = "lecturerId")
    void toOfferDto(@MappingTarget OfferDto offerDto, OfferEditionRequest offerEditionRequest);
    @Mapping(target = "lecturerId", source = "lecturer.id")
    CourseOfferDto toCourseOfferDto(OfferDto offerDto);
    CourseOffersGetResponse toCourseOffersGetResponse(OffersDto offers);
    @Mapping(target = "courseId", source = "course.id")
    LecturerOfferDto toLecturerOfferDto(OfferDto offerDto);
    LecturerOffersGetResponse toLecturerOffersGetResponse(OffersDto offers);
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "lecturerId", source = "lecturer.id")
    SemesterOfferDto toSemesterOfferDto(OfferDto offerDto);
    SemesterOffersGetResponse toSemesterOffersGetResponse(OffersDto offers);
}
