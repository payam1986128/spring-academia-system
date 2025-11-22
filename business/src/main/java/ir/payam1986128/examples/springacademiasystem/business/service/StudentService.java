package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.EntityNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.StudentBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.StudentServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentNumberDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentsDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static ir.payam1986128.examples.springacademiasystem.business.util.UUIDUtil.parseId;

@Service
@Transactional
@AllArgsConstructor
public class StudentService implements StudentServiceApi {

    private final StudentDaoApi dao;
    private final StudentNumberDaoApi studentNumberDao;
    private final StudentBusinessMapper mapper;

    @Override
    public StudentGetResponse getStudent(String id) {
        UUID studentId = parseId(id);
        StudentDto student = getStudent(studentId);
        return mapper.toStudentGetResponse(student);
    }

    private StudentDto getStudent(UUID id) {
        Optional<StudentDto> optionalStudent = dao.getStudent(id);
        if (optionalStudent.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return optionalStudent.get();
    }

    @Override
    public StudentsGetResponse getStudents(StudentsGetRequest request) {
        StudentFilterDto filter = mapper.toStudentFilterDto(request);
        StudentsDto students = dao.getStudents(filter);
        return mapper.toStudentsGetResponse(students);
    }

    @Override
    public StudentCreationResponse create(StudentCreationRequest request) {
        StudentDto student = mapper.toStudentDto(request);
        String studentNumber = studentNumberDao.generateStudentNumber();
        UUID id = dao.addStudent(student);
        return StudentCreationResponse.builder()
                .id(mapper.toString(id))
                .studentNumber(studentNumber)
                .build();
    }

    @Override
    public void update(String id, StudentEditionRequest request) {
        UUID studentId = parseId(id);
        StudentDto found = getStudent(studentId);
        mapper.toStudentDto(found, request);
        dao.editStudent(found);
    }

    @Override
    public void delete(String id) {
        UUID studentId = parseId(id);
        StudentDto student = getStudent(studentId);
        dao.deleteStudent(student.getId());
    }
}
