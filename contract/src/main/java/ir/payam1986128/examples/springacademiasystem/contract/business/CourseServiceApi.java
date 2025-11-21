package ir.payam1986128.examples.springacademiasystem.contract.business;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.*;

public interface CourseServiceApi {
    CourseGetResponse getCourse(String id);
    CoursesGetResponse getCourses(CoursesGetRequest request);
    CourseCreationResponse create(CourseCreationRequest request);
    void update(String id, CourseEditionRequest request);
    void delete(String id);
}
