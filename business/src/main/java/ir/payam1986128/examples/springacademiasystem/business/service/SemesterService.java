package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.SemesterBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.SemesterServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.SemesterDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterEditionRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ir.payam1986128.examples.springacademiasystem.business.util.UUIDUtil.parseId;

@Service
@Transactional
@AllArgsConstructor
public class SemesterService implements SemesterServiceApi {

    private final SemesterDaoApi dao;
    private final SemesterBusinessMapper mapper;

    @Override
    public SemesterGetResponse getSemester(String id) {
        UUID semesterId = parseId(id);
        SemesterDto semester = getSemester(semesterId);
        return mapper.toSemesterGetResponse(semester);
    }

    private SemesterDto getSemester(UUID id) {
        Optional<SemesterDto> optionalSemester = dao.getSemester(id);
        if (optionalSemester.isEmpty()) {
            throw new EntityNotFoundException("semester not found");
        }
        return optionalSemester.get();
    }

    @Override
    public SemesterDto getCurrentSemester() {
        Optional<SemesterDto> optionalSemester = dao.getCurrentSemester();
        if (optionalSemester.isEmpty()) {
            throw new EntityNotFoundException("semester not found");
        }
        return optionalSemester.get();
    }

    @Override
    public SemesterCreationResponse create(SemesterCreationRequest request) {
        SemesterDto semester = mapper.toSemesterDto(request);
        UUID id = dao.addSemester(semester);
        return new SemesterCreationResponse(mapper.toString(id));
    }

    @Override
    public void update(String id, SemesterEditionRequest request) {
        UUID semesterId = parseId(id);
        SemesterDto found = getSemester(semesterId);
        mapper.toSemesterDto(found, request);
        dao.editSemester(found);
    }

    @Override
    public void delete(String id) {
        UUID semesterId = parseId(id);
        SemesterDto semester = getSemester(semesterId);
        dao.deleteSemester(semester.getId());
    }
}
