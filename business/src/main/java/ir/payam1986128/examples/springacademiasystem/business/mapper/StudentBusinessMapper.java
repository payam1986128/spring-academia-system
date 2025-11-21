package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentsDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentBusinessMapper extends CommonBusinessMapper {
    StudentGetResponse toStudentGetResponse(StudentDto student);
    StudentFilterDto toStudentFilterDto(StudentsGetRequest studentsGetRequest);
    StudentsGetResponse toStudentsGetResponse(StudentsDto students);
    StudentDto toStudentDto(StudentDto student);
    List<StudentDto> toStudentsDto(List<StudentDto> studentsDto);
    StudentDto toStudentDto(StudentCreationRequest studentCreationRequest);
    StudentDto toStudentDto(StudentEditionRequest studentEditionRequest);
}
