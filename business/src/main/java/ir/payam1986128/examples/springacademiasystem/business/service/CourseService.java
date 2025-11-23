package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.CourseBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.CourseServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.CourseDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CoursesDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ir.payam1986128.examples.springacademiasystem.business.util.UUIDUtil.parseId;

@Service
@Transactional
@AllArgsConstructor
public class CourseService implements CourseServiceApi {

    private final CourseDaoApi dao;
    private final CourseBusinessMapper mapper;

    @Override
    public CourseGetResponse getCourse(String id) {
        UUID courseId = parseId(id);
        CourseDto course = getCourse(courseId);
        return mapper.toCourseGetResponse(course);
    }

    private CourseDto getCourse(UUID id) {
        Optional<CourseDto> optionalCourse = dao.getCourse(id);
        if (optionalCourse.isEmpty()) {
            throw new EntityNotFoundException("Course not found");
        }
        return optionalCourse.get();
    }

    @Override
    public CoursesGetResponse getCourses(CoursesGetRequest request) {
        CourseFilterDto filter = mapper.toCourseFilterDto(request);
        CoursesDto courses = dao.getCourses(filter);
        return mapper.toCoursesGetResponse(courses);
    }

    @Override
    public CourseCreationResponse create(CourseCreationRequest request) {
        CourseDto course = mapper.toCourseDto(request);
        UUID id = dao.addCourse(course);
        return new CourseCreationResponse(mapper.toString(id));
    }

    @Override
    public void update(String id, CourseEditionRequest request) {
        UUID courseId = parseId(id);
        CourseDto found = getCourse(courseId);
        mapper.toCourseDto(found, request);
        dao.editCourse(found);
    }

    @Override
    public void delete(String id) {
        UUID courseId = parseId(id);
        CourseDto course = getCourse(courseId);
        dao.deleteCourse(course.getId());
    }
}
