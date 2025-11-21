package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Lecturer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerPersistenceMapper {
    LecturerDto toLecturerDto(Lecturer lecturer);
    List<LecturerDto> toLecturersDto(List<Lecturer> lecturers);
    Lecturer toLecturer(LecturerDto lecturerDto);
}
