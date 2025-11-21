package ir.payam1986128.examples.springacademiasystem.contract.business;


import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentCreationResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentGetResponse;

public interface EnrollmentServiceApi {
    EnrollmentCreationResponse register(String offerId, String username);

    EnrollmentGetResponse getEnrollment(String offerId, String username);

    void drop(String offerId, String username);
}
