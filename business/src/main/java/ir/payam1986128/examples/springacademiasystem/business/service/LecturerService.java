package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.LecturerBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.LecturerServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.LecturerDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturersDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ir.payam1986128.examples.springacademiasystem.business.util.UUIDUtil.parseId;

@Service
@Transactional
@AllArgsConstructor
public class LecturerService implements LecturerServiceApi {

    private final LecturerDaoApi dao;
    private final LecturerBusinessMapper mapper;

    @Override
    public LecturerGetResponse getLecturer(String id) {
        UUID lecturerId = parseId(id);
        LecturerDto lecturer = getLecturer(lecturerId);
        return mapper.toLecturerGetResponse(lecturer);
    }

    private LecturerDto getLecturer(UUID id) {
        Optional<LecturerDto> optionalLecturer = dao.getLecturer(id);
        if (optionalLecturer.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return optionalLecturer.get();
    }

    @Override
    public LecturersGetResponse getLecturers(LecturersGetRequest request) {
        LecturerFilterDto filter = mapper.toLecturerFilterDto(request);
        LecturersDto lecturers = dao.getLecturers(filter);
        return mapper.toLecturersGetResponse(lecturers);
    }

    @Override
    public LecturerCreationResponse create(LecturerCreationRequest request) {
        LecturerDto lecturer = mapper.toLecturerDto(request);
        UUID id = dao.addLecturer(lecturer);
        return new LecturerCreationResponse(mapper.toString(id));
    }

    @Override
    public void update(String id, LecturerEditionRequest request) {
        UUID lecturerId = parseId(id);
        LecturerDto found = getLecturer(lecturerId);
        mapper.toLecturerDto(found, request);
        dao.editLecturer(found);
    }

    @Override
    public void delete(String id) {
        UUID lecturerId = parseId(id);
        LecturerDto lecturer = getLecturer(lecturerId);
        dao.deleteLecturer(lecturer.getId());
    }
}
