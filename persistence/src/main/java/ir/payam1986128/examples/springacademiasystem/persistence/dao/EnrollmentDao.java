package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.EnrollmentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Enrollment;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.EnrollmentPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EnrollmentDao implements EnrollmentDaoApi {

    private final EnrollmentRepository repository;
    private final EnrollmentPersistenceMapper mapper;

    @Override
    public Optional<EnrollmentDto> getEnrollment(UUID id) {
        Optional<Enrollment> optionalEnrollment = repository.findById(id);
        return optionalEnrollment.map(mapper::toEnrollmentDto);
    }

    @Override
    public Optional<EnrollmentDto> getEnrollment(UUID offerId, UUID id, UUID studentId) {
        Optional<Enrollment> optionalEnrollment = repository.findByIdAndOffer_IdAndStudent_Id(id, offerId, studentId);
        return optionalEnrollment.map(mapper::toEnrollmentDto);
    }

    @Override
    public UUID addEnrollment(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = mapper.toEnrollment(enrollmentDto);
        repository.save(enrollment);
        return enrollment.getId();
    }

    @Override
    public void deleteEnrollment(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isEnrollmentExist(UUID id) {
        return repository.existsById(id);
    }
}
