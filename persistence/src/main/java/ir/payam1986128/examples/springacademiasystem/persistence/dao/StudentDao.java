package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.StudentPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentDao implements StudentDaoApi {

    private final StudentRepository repository;
    private final StudentPersistenceMapper mapper;
}
