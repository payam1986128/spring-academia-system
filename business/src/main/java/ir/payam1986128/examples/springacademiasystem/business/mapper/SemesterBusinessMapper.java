package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterCreationRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterEditionRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester.SemesterGetResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SemesterBusinessMapper extends CommonBusinessMapper {
    SemesterGetResponse toSemesterGetResponse(SemesterDto semester);
    SemesterDto toSemesterDto(SemesterDto semester);
    List<SemesterDto> toSemestersDto(List<SemesterDto> semestersDto);
    SemesterDto toSemesterDto(SemesterCreationRequest semesterCreationRequest);
    SemesterDto toSemesterDto(SemesterEditionRequest semesterEditionRequest);
}
