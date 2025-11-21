package ir.payam1986128.examples.springacademiasystem.contract.business;


import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.*;

public interface SemesterServiceApi {
    SemesterGetResponse getSemester(String id);

    SemestersGetResponse getSemesters(SemestersGetRequest request);

    SemesterCreationResponse create(SemesterCreationRequest request);

    void update(String id, SemesterEditionRequest request);

    void delete(String id);
}
