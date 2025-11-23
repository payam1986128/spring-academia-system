package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentBusinessMapper extends CommonBusinessMapper {
    @Mapping(target = "offerId", source = "offer.id")
    @Mapping(target = "studentId", source = "student.id")
    EnrollmentGetResponse toEnrollmentGetResponse(EnrollmentDto enrollmentDto);
}
