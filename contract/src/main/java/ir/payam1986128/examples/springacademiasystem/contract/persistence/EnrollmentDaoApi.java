package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;

import java.util.Optional;
import java.util.UUID;

public interface EnrollmentDaoApi {
    Optional<EnrollmentDto> getEnrollment(UUID id);
    Optional<EnrollmentDto> getEnrollment(UUID offerId, UUID id, UUID studentId);
    UUID addEnrollment(EnrollmentDto enrollmentDto);
    void deleteEnrollment(UUID id);
    boolean isEnrollmentExist(UUID id);
}
