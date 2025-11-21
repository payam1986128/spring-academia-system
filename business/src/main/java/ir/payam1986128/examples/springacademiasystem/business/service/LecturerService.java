package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.mapper.LecturerBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.LecturerServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.LecturerDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LecturerService implements LecturerServiceApi {

    private final LecturerDaoApi dao;
    private final LecturerBusinessMapper mapper;

    @Override
    public LecturerGetResponse getLecturer(String id) {
        return null;
    }

    @Override
    public LecturersGetResponse getLecturers(LecturersGetRequest request) {
        return null;
    }

    @Override
    public LecturerCreationResponse create(LecturerCreationRequest request) {
        return null;
    }

    @Override
    public void update(String id, LecturerEditionRequest request) {

    }

    @Override
    public void delete(String id) {

    }
}
