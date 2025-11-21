package ir.payam1986128.examples.springacademiasystem.contract.business;


import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.*;

public interface StudentServiceApi {
    StudentGetResponse getStudent(String id);

    StudentsGetResponse getStudents(StudentsGetRequest request);

    StudentCreationResponse create(StudentCreationRequest request);

    void update(String id, StudentEditionRequest request);

    void delete(String id);
}
