package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.EnrollmentCapacityExceededException;
import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.EnrollmentBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.EnrollmentServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.EnrollmentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.OfferDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.UserDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment.EnrollmentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentCreationResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.enrollment.EnrollmentGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ir.payam1986128.examples.springacademiasystem.business.util.UUIDUtil.parseId;

@Service
@Transactional
@AllArgsConstructor
public class EnrollmentService implements EnrollmentServiceApi {

    private final EnrollmentDaoApi dao;
    private final OfferDaoApi offerDao;
    private final UserDaoApi userDao;
    private final EnrollmentBusinessMapper mapper;

    @Override
    public EnrollmentCreationResponse register(String offerId, String username) {
        Optional<OfferDto> offer = offerDao.getOffer(parseId(offerId));
        if (offer.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<UserDto> studentUser = userDao.findByUsername(username);
        if (studentUser.isEmpty()) {
            throw new EntityNotFoundException();
        }

        OfferDto offerDto = offer.get();
        offerDto.increaseRegistered();

        if (offerDto.getCapacity() < offerDto.getRegistered()) {
            throw new EnrollmentCapacityExceededException();
        }
        EnrollmentDto enrollment = new EnrollmentDto();
        enrollment.setOffer(offerDto);
        enrollment.setStudent(studentUser.get().getStudent());
        UUID savedId = dao.addEnrollment(enrollment);

        offerDao.editOffer(offerDto);

        return new EnrollmentCreationResponse(savedId.toString());
    }

    @Override
    public EnrollmentGetResponse getEnrollment(String offerId, String id, String username) {
        UUID oId = parseId(offerId);
        UUID enrollmentId = parseId(id);
        EnrollmentDto enrollment = getEnrollment(oId, enrollmentId, username);
        return mapper.toEnrollmentGetResponse(enrollment);
    }

    private EnrollmentDto getEnrollment(UUID offerId, UUID id, String username) {
        Optional<UserDto> studentUser = userDao.findByUsername(username);
        if (studentUser.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<EnrollmentDto> optionalEnrollment = dao.getEnrollment(offerId, id, studentUser.get().getStudent().getId());
        if (optionalEnrollment.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return optionalEnrollment.get();
    }

    @Override
    public void drop(String offerId, String id, String username) {
        Optional<UserDto> studentUser = userDao.findByUsername(username);
        if (studentUser.isEmpty()) {
            throw new EntityNotFoundException();
        }
        Optional<OfferDto> offer = offerDao.getOffer(parseId(offerId));
        if (offer.isEmpty()) {
            throw new EntityNotFoundException();
        }

        OfferDto offerDto = offer.get();
        offerDto.decreaseRegistered();

        EnrollmentDto enrollment = getEnrollment(offer.get().getId(), parseId(id), username);
        dao.deleteEnrollment(enrollment.getId());
        offerDao.editOffer(offerDto);
    }
}
