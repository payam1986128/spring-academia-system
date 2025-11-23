package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturersDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerBusinessMapper extends CommonBusinessMapper {
    LecturerGetResponse toLecturerGetResponse(LecturerDto lecturer);
    LecturerFilterDto toLecturerFilterDto(LecturersGetRequest lecturersGetRequest);
    LecturersGetResponse toLecturersGetResponse(LecturersDto lecturers);
    ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.LecturerDto toLecturerDto(LecturerDto lecturer);
    LecturerDto toLecturerDto(LecturerCreationRequest lecturerCreationRequest);
    void toLecturerDto(@MappingTarget LecturerDto lecturerDto, LecturerEditionRequest lecturerEditionRequest);
}
