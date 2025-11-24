package ir.payam1986128.examples.springacademiasystem.business.service.offerservice;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.exception.InvalidUUIDException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.OfferBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.business.service.OfferService;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.SemesterDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.offer.OfferEditionRequest;
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
public class EditUnitTest {

    @Mock
    private OfferDaoApi dao;

    @Mock
    private SemesterDaoApi semesterDao;

    @Mock
    private OfferBusinessMapper mapper;

    @InjectMocks
    private OfferService offerService;

    @Test
    void givenCorrectOfferRequest_whenEdit_thenSuccess() {
        OfferDto offer = Instancio.create(OfferDto.class);

        when(dao.getOffer(any())).thenReturn(Optional.of(offer));
        doNothing().when(mapper).toOfferDto(any(), any());

        offerService.update(offer.getId().toString(), new OfferEditionRequest());
    }

    @Test
    void givenInvalidId_whenEdit_thenFailed() {
        InvalidUUIDException exception = assertThrows(
                InvalidUUIDException.class,
                () -> offerService.update("invalid uuid", new OfferEditionRequest())
        );

        assertEquals("Invalid UUID", exception.getMessage());
    }

    @Test
    void givenNotFoundOffer_whenEdit_thenFailed() {
        when(dao.getOffer(any())).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> offerService.update(UUID.randomUUID().toString(), new OfferEditionRequest())
        );

        assertEquals("offer not found", exception.getMessage());
    }
}
