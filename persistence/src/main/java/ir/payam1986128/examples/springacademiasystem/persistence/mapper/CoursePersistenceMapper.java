package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoursePersistenceMapper {
    CourseDto toCourseDto(Course course);
    Course toCourse(CourseDto courseDto);
    List<CourseDto> toCoursesDto(List<Course> content);
}
