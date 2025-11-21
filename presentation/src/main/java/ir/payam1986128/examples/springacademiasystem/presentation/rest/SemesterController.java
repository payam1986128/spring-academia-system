package ir.payam1986128.examples.springacademiasystem.presentation.rest;

import ir.payam1986128.examples.springacademiasystem.contract.business.SemesterServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/semesters")
@AllArgsConstructor
public class SemesterController {

    private SemesterServiceApi service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SemesterGetResponse getSemester(@PathVariable("id") String id) {
        return service.getSemester(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SemestersGetResponse getSemesters(@Valid SemestersGetRequest request) {
        return service.getSemesters(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SemesterCreationResponse create(@Valid @RequestBody SemesterCreationRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @Valid @RequestBody SemesterEditionRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
