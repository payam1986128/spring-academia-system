package ir.payam1986128.examples.springacademiasystem.presentation.rest;

import ir.payam1986128.examples.springacademiasystem.contract.business.CourseServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.business.OfferServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.course.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private CourseServiceApi service;
    private OfferServiceApi offerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseGetResponse getCourse(@PathVariable("id") String id) {
        return service.getCourse(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CoursesGetResponse getCourses(@Valid CoursesGetRequest request) {
        return service.getCourses(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseCreationResponse create(@Valid @RequestBody CourseCreationRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @Valid @RequestBody CourseEditionRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @GetMapping("/{id}/offers")
    @ResponseStatus(HttpStatus.OK)
    public CourseOffersGetResponse getCourseOffers(@PathVariable String id) {
        return offerService.getOffersByCourse(id);
    }
}
