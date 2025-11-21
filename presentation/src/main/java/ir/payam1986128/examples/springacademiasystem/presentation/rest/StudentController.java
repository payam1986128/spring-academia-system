package ir.payam1986128.examples.springacademiasystem.presentation.rest;

import ir.payam1986128.examples.springacademiasystem.contract.business.StudentServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private StudentServiceApi service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentGetResponse getStudent(@PathVariable("id") String id) {
        return service.getStudent(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentsGetResponse getStudents(@Valid StudentsGetRequest request) {
        return service.getStudents(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCreationResponse create(@Valid @RequestBody StudentCreationRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @Valid @RequestBody StudentEditionRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
