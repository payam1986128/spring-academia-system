package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.mapper.EnrollmentBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.EnrollmentServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.EnrollmentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentCreationResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EnrollmentService implements EnrollmentServiceApi {

    private final EnrollmentDaoApi dao;
    private final EnrollmentBusinessMapper mapper;

    @Override
    public EnrollmentCreationResponse register(String offerId, String username) {
        return null;
    }

    @Override
    public EnrollmentGetResponse getEnrollment(String offerId, String id, String username) {
        return null;
    }

    @Override
    public void drop(String offerId, String id, String username) {

    }
}
