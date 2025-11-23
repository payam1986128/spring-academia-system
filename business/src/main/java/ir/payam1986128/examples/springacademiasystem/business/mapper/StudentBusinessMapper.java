package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentsDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentBusinessMapper extends CommonBusinessMapper {
    StudentGetResponse toStudentGetResponse(StudentDto student);
    StudentFilterDto toStudentFilterDto(StudentsGetRequest studentsGetRequest);
    StudentsGetResponse toStudentsGetResponse(StudentsDto students);
    ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student.StudentDto toStudentDto(StudentDto student);
    StudentDto toStudentDto(StudentCreationRequest studentCreationRequest);
    @Mapping(target = "studentNumber", ignore = true)
    void toStudentDto(@MappingTarget StudentDto student, StudentEditionRequest studentEditionRequest);
}
