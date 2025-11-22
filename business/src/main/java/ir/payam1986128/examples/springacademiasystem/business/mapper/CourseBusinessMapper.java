package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CoursesDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseBusinessMapper extends CommonBusinessMapper {
    CourseGetResponse toCourseGetResponse(CourseDto course);
    CourseFilterDto toCourseFilterDto(CoursesGetRequest coursesGetRequest);
    CoursesGetResponse toCoursesGetResponse(CoursesDto courses);
    CourseDto toCourseDto(CourseDto course);
    List<CourseDto> toCoursesDto(List<CourseDto> coursesDto);
    CourseDto toCourseDto(CourseCreationRequest courseCreationRequest);
    void toCourseDto(@MappingTarget CourseDto courseDto, CourseEditionRequest courseEditionRequest);
}
