package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentsDto;

import java.util.Optional;
import java.util.UUID;

public interface StudentDaoApi {
    Optional<StudentDto> getStudent(UUID id);
    StudentsDto getStudents(StudentFilterDto filter);
    UUID addStudent(StudentDto studentDto);
    void editStudent(UUID id, StudentDto studentDto);
    void deleteStudent(UUID id);
    boolean isStudentExist(UUID id);
}
