package ir.payam1986128.examples.springacademiasystem.contract.business;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterEditionRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterGetResponse;

public interface SemesterServiceApi {
    SemesterGetResponse getSemester(String id);

    SemesterCreationResponse create(SemesterCreationRequest request);

    void update(String id, SemesterEditionRequest request);

    void delete(String id);
}
