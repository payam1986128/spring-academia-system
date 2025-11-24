package ir.payam1986128.examples.springacademiasystem.business.service.offerservice;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.OfferBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.business.service.OfferService;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.SemesterDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.OfferCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.OfferCreationResponse;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUnitTest {

    @Mock
    private OfferDaoApi dao;

    @Mock
    private SemesterDaoApi semesterDao;

    @Mock
    private OfferBusinessMapper mapper;

    @InjectMocks
    private OfferService offerService;

    @Test
    void givenCorrectOfferRequest_whenCreate_thenSuccess() {
        OfferDto offer = Instancio.create(OfferDto.class);

        when(mapper.toOfferDto(any(OfferCreationRequest.class))).thenReturn(offer);
        when(semesterDao.getCurrentSemester()).thenReturn(Optional.of(new SemesterDto()));
        when(dao.addOffer(any())).thenReturn(offer.getId());
        when(mapper.toString(any())).thenReturn(offer.getId().toString());

        OfferCreationResponse response = offerService.create(new OfferCreationRequest());

        assertEquals(offer.getId().toString(), response.getId());
    }

    @Test
    void givenNotDefinedCurrentSemester_whenCreate_thenFailed() {
        OfferDto offer = Instancio.create(OfferDto.class);

        when(mapper.toOfferDto(any(OfferCreationRequest.class))).thenReturn(offer);
        when(semesterDao.getCurrentSemester()).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> offerService.create(new OfferCreationRequest())
        );

        assertEquals("Current semester not found", exception.getMessage());
    }
}
