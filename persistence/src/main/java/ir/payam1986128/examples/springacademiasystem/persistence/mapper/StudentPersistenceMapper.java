package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {
    StudentDto toStudentDto(Student student);
    List<StudentDto> toStudentsDto(List<Student> students);
    Student toStudent(StudentDto studentDto);
}
