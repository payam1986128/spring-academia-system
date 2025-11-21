package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.CourseDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CourseFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.course.CoursesDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Course;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.QCourse;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.CoursePersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CourseDao implements CourseDaoApi {

    private final CourseRepository repository;
    private final CoursePersistenceMapper mapper;

    @Override
    public Optional<CourseDto> getCourse(UUID id) {
        Optional<Course> optionalCourse = repository.findById(id);
        return optionalCourse.map(mapper::toCourseDto);
    }

    @Override
    public CoursesDto getCourses(CourseFilterDto filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage()-1, filter.getPageSize());
        if (filter.getSort() != null && filter.getSortDirection() != null) {
            pageRequest.withSort(Sort.Direction.valueOf(filter.getSortDirection().name()), filter.getSort());
        }
        BooleanExpression predicate = QCourse.course.name.like("%"+filter.getName()+"%");
        if (filter.getUnits() != null) {
            predicate = predicate.and(QCourse.course.units.eq(filter.getUnits()));
        }
        Page<Course> coursesPage = repository.findAll(predicate, pageRequest);
        return CoursesDto.builder()
                .courses(mapper.toCoursesDto(coursesPage.getContent()))
                .total(coursesPage.getTotalElements())
                .build();
    }

    @Override
    public UUID addCourse(CourseDto courseDto) {
        Course course = mapper.toCourse(courseDto);
        repository.save(course);
        return course.getId();
    }

    @Override
    public void editCourse(UUID id, CourseDto courseDto) {
        Course course = mapper.toCourse(courseDto);
        course.setId(id);
        repository.save(course);
    }

    @Override
    public void deleteCourse(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isCourseExist(UUID id) {
        return repository.existsById(id);
    }
}
