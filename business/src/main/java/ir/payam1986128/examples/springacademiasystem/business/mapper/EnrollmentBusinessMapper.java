package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentGetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentBusinessMapper extends CommonBusinessMapper {
    EnrollmentGetResponse toEnrollmentGetResponse(EnrollmentDto course);
    EnrollmentDto toEnrollmentDto(EnrollmentDto course);
}
