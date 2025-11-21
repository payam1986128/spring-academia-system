package ir.payam1986128.examples.springacademiasystem.presentation.rest;

import ir.payam1986128.examples.springacademiasystem.contract.business.LecturerServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.business.OfferServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecturers")
@AllArgsConstructor
public class LecturerController {

    private LecturerServiceApi service;
    private OfferServiceApi offerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LecturerGetResponse getLecturer(@PathVariable("id") String id) {
        return service.getLecturer(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public LecturersGetResponse getLecturers(@Valid LecturersGetRequest request) {
        return service.getLecturers(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LecturerCreationResponse create(@Valid @RequestBody LecturerCreationRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @Valid @RequestBody LecturerEditionRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @GetMapping("/{id}/offers")
    @ResponseStatus(HttpStatus.OK)
    public LecturerOffersGetResponse getLecturerOffers(@PathVariable String id) {
        return offerService.getOffersByLecturer(id);
    }
}
