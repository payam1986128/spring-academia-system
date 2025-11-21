package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturersDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerBusinessMapper extends CommonBusinessMapper {
    LecturerGetResponse toLecturerGetResponse(LecturerDto lecturer);
    LecturerFilterDto toLecturerFilterDto(LecturersGetRequest lecturersGetRequest);
    LecturersGetResponse toLecturersGetResponse(LecturersDto lecturers);
    LecturerDto toLecturerDto(LecturerDto lecturer);
    List<LecturerDto> toLecturersDto(List<LecturerDto> lecturersDto);
    LecturerDto toLecturerDto(LecturerCreationRequest lecturerCreationRequest);
    LecturerDto toLecturerDto(LecturerEditionRequest lecturerEditionRequest);
}
