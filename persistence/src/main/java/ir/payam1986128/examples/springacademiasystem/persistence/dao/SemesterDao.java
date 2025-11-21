package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.SemesterDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.SemesterPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.SemesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SemesterDao implements SemesterDaoApi {

    private final SemesterRepository repository;
    private final SemesterPersistenceMapper mapper;
}
