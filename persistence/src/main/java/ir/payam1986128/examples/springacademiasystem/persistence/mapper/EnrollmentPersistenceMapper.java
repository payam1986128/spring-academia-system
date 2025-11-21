package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Enrollment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentPersistenceMapper {
    EnrollmentDto toEnrollmentDto(Enrollment enrollment);
    Enrollment toEnrollment(EnrollmentDto enrollmentDto);
}
