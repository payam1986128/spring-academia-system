package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.mapper.CourseBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.CourseServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.CourseDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CourseService implements CourseServiceApi {

    private final CourseDaoApi dao;
    private final CourseBusinessMapper mapper;

    @Override
    public CourseGetResponse getCourse(String id) {
        return null;
    }

    @Override
    public CoursesGetResponse getCourses(CoursesGetRequest request) {
        return null;
    }

    @Override
    public CourseCreationResponse create(CourseCreationRequest request) {
        return null;
    }

    @Override
    public void update(String id, CourseEditionRequest request) {

    }

    @Override
    public void delete(String id) {

    }
}
