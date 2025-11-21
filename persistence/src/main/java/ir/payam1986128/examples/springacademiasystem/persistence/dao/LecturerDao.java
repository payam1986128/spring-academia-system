package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.LecturerDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.LecturerPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LecturerDao implements LecturerDaoApi {

    private final LecturerRepository repository;
    private final LecturerPersistenceMapper mapper;
}
