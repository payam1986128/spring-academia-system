package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.CourseDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.CoursePersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseDao implements CourseDaoApi {

    private final CourseRepository repository;
    private final CoursePersistenceMapper mapper;
}
