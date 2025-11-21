package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.mapper.StudentBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.StudentServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService implements StudentServiceApi {

    private final StudentDaoApi dao;
    private final StudentBusinessMapper mapper;

    @Override
    public StudentGetResponse getStudent(String id) {
        return null;
    }

    @Override
    public StudentsGetResponse getStudents(StudentsGetRequest request) {
        return null;
    }

    @Override
    public StudentCreationResponse create(StudentCreationRequest request) {
        return null;
    }

    @Override
    public void update(String id, StudentEditionRequest request) {

    }

    @Override
    public void delete(String id) {

    }
}
