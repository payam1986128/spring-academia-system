package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.mapper.SemesterBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.SemesterServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.SemesterDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SemesterService implements SemesterServiceApi {

    private final SemesterDaoApi dao;
    private final SemesterBusinessMapper mapper;

    @Override
    public SemesterGetResponse getSemester(String id) {
        return null;
    }

    @Override
    public SemesterCreationResponse create(SemesterCreationRequest request) {
        return null;
    }

    @Override
    public void update(String id, SemesterEditionRequest request) {

    }

    @Override
    public void delete(String id) {

    }
}
