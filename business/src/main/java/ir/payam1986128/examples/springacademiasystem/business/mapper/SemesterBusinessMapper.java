package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterEditionRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SemesterBusinessMapper extends CommonBusinessMapper {
    SemesterGetResponse toSemesterGetResponse(SemesterDto semester);
    ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterDto toSemesterDto(SemesterDto semester);
    SemesterDto toSemesterDto(SemesterCreationRequest semesterCreationRequest);
    void toSemesterDto(@MappingTarget SemesterDto semester, SemesterEditionRequest semesterEditionRequest);
}
