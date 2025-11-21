package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CoursesDto;

import java.util.Optional;
import java.util.UUID;

public interface CourseDaoApi {
    Optional<CourseDto> getCourse(UUID id);
    CoursesDto getCourses(CourseFilterDto filter);
    UUID addCourse(CourseDto courseDto);
    void editCourse(UUID id, CourseDto courseDto);
    void deleteCourse(UUID id);
    boolean isCourseExist(UUID id);
}
