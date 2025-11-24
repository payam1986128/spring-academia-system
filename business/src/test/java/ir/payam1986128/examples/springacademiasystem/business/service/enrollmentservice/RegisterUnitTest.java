package ir.payam1986128.examples.springacademiasystem.business.service.enrollmentservice;

import ir.payam1986128.examples.springacademiasystem.business.exception.EnrollmentAlreadyExistsException;
import ir.payam1986128.examples.springacademiasystem.business.exception.EnrollmentCapacityExceededException;
import ir.payam1986128.examples.springacademiasystem.business.service.EnrollmentService;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.EnrollmentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.UserDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentCreationResponse;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterUnitTest {

    @Mock
    private EnrollmentDaoApi enrollmentDao;

    @Mock
    private OfferDaoApi offerDao;

    @Mock
    private UserDaoApi userDao;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @Test
    void givenCorrectOfferAndStudent_whenEnroll_thenSuccess() {
        String offerId = UUID.randomUUID().toString();
        OfferDto offer = Instancio.create(OfferDto.class);
        UserDto user = Instancio.create(UserDto.class);
        UUID savedId = UUID.randomUUID();

        when(offerDao.getOffer(any())).thenReturn(Optional.of(offer));
        when(userDao.findByUsername(any())).thenReturn(Optional.of(user));
        when(enrollmentDao.getEnrollment(any(), any())).thenReturn(Optional.empty());
        when(enrollmentDao.addEnrollment(any())).thenReturn(savedId);
        when(offerDao.increaseRegistered(any())).thenReturn(true);

        EnrollmentCreationResponse result = enrollmentService.register(offerId, "stu1");

        assertEquals(savedId.toString(), result.getId());
    }

    @Test
    void givenEnrolledStudent_whenEnroll_thenFailed() {
        String offerId = UUID.randomUUID().toString();
        OfferDto offer = Instancio.create(OfferDto.class);
        UserDto user = Instancio.create(UserDto.class);

        when(offerDao.getOffer(any())).thenReturn(Optional.of(offer));
        when(userDao.findByUsername(any())).thenReturn(Optional.of(user));
        when(enrollmentDao.getEnrollment(any(), any())).thenReturn(Optional.of(new EnrollmentDto()));

        EnrollmentAlreadyExistsException exception = assertThrows(
                EnrollmentAlreadyExistsException.class,
                () -> enrollmentService.register(offerId, "stu1")
        );

        assertEquals("This student has already been enrolled for that offer", exception.getMessage());
    }

    @Test
    void givenEnrollmentCapacityExceeded_whenEnroll_thenFailed() {
        String offerId = UUID.randomUUID().toString();
        OfferDto offer = Instancio.create(OfferDto.class);
        UserDto user = Instancio.create(UserDto.class);
        UUID savedId = UUID.randomUUID();

        when(offerDao.getOffer(any())).thenReturn(Optional.of(offer));
        when(userDao.findByUsername(any())).thenReturn(Optional.of(user));
        when(enrollmentDao.getEnrollment(any(), any())).thenReturn(Optional.empty());
        when(enrollmentDao.addEnrollment(any())).thenReturn(savedId);
        when(offerDao.increaseRegistered(any())).thenReturn(false);

        EnrollmentCapacityExceededException exception = assertThrows(
                EnrollmentCapacityExceededException.class,
                () -> enrollmentService.register(offerId, "stu1")
        );

        assertEquals("Enrollment capacity exceeded", exception.getMessage());
    }
}
