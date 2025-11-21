package ir.payam1986128.examples.springacademiasystem.presentation.rest;

import ir.payam1986128.examples.springacademiasystem.contract.business.EnrollmentServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.business.OfferServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentCreationResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentGetResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/semesters")
@AllArgsConstructor
public class OfferController {

    private OfferServiceApi service;
    private EnrollmentServiceApi enrollmentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OfferGetResponse getOffer(@PathVariable("id") String id) {
        return service.getOffer(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public OffersGetResponse getOffers(@Valid OffersGetRequest request) {
        return service.getOffers(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfferCreationResponse create(@Valid @RequestBody OfferCreationRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String id, @Valid @RequestBody OfferEditionRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

    @PostMapping("/{offerId}/enrollments")
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentCreationResponse register(
            @PathVariable("offerId") String offerId,
            @AuthenticationPrincipal UserDetails user
    ) {
        return enrollmentService.register(offerId, user.getUsername());
    }

    @GetMapping("/{offerId}/enrollments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnrollmentGetResponse GetEnrollment(
            @PathVariable("offerId") String offerId,
            @PathVariable("id") String id,
            @AuthenticationPrincipal UserDetails user
    ) {
        return enrollmentService.getEnrollment(offerId, user.getUsername());
    }

    @DeleteMapping("/{offerId}/enrollments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void drop(
            @PathVariable("offerId") String offerId,
            @PathVariable("id") String id,
            @AuthenticationPrincipal UserDetails user
    ) {
        enrollmentService.drop(offerId, user.getUsername());
    }
}
