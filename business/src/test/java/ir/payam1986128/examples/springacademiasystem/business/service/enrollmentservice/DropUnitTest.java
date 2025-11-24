package ir.payam1986128.examples.springacademiasystem.business.service.enrollmentservice;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.service.EnrollmentService;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.EnrollmentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.UserDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DropUnitTest {

    @Mock
    private EnrollmentDaoApi enrollmentDao;

    @Mock
    private OfferDaoApi offerDao;

    @Mock
    private UserDaoApi userDao;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @Test
    void givenCorrectOfferAndStudent_whenDrop_thenSuccess() {
        String offerId = UUID.randomUUID().toString();
        OfferDto offer = Instancio.create(OfferDto.class);
        UserDto user = Instancio.create(UserDto.class);
        String enrollmentId = UUID.randomUUID().toString();

        when(userDao.findByUsername(any())).thenReturn(Optional.of(user));
        when(offerDao.getOffer(any())).thenReturn(Optional.of(offer));
        when(enrollmentDao.getEnrollment(any(), any(), any())).thenReturn(Optional.of(new EnrollmentDto()));
        doNothing().when(enrollmentDao).deleteEnrollment(any());
        when(offerDao.decreaseRegistered(any())).thenReturn(true);

        enrollmentService.drop(offerId, enrollmentId, "stu1");
    }

    @Test
    void givenNotEnrolledStudent_whenEnroll_thenFailed() {
        String offerId = UUID.randomUUID().toString();
        OfferDto offer = Instancio.create(OfferDto.class);
        UserDto user = Instancio.create(UserDto.class);
        String enrollmentId = UUID.randomUUID().toString();

        when(offerDao.getOffer(any())).thenReturn(Optional.of(offer));
        when(userDao.findByUsername(any())).thenReturn(Optional.of(user));
        when(enrollmentDao.getEnrollment(any(), any(), any())).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> enrollmentService.drop(offerId, enrollmentId, "stu1")
        );

        assertEquals("enrollment not found", exception.getMessage());
    }
}
