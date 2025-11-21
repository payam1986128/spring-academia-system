package ir.payam1986128.examples.springacademiasystem.contract.business;


import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.*;

public interface LecturerServiceApi {
    LecturerGetResponse getLecturer(String id);

    LecturersGetResponse getLecturers(LecturersGetRequest request);

    LecturerCreationResponse create(LecturerCreationRequest request);

    void update(String id, LecturerEditionRequest request);

    void delete(String id);
}
