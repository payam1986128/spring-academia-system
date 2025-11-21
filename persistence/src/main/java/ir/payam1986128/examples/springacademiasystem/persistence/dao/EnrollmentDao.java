package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.EnrollmentDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.EnrollmentPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.EnrollmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrollmentDao implements EnrollmentDaoApi {

    private final EnrollmentRepository repository;
    private final EnrollmentPersistenceMapper mapper;
}
