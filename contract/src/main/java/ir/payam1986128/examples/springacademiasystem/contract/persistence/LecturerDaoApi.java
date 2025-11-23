package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturersDto;

import java.util.Optional;
import java.util.UUID;

public interface LecturerDaoApi {
    Optional<LecturerDto> getLecturer(UUID id);
    LecturersDto getLecturers(LecturerFilterDto filter);
    UUID addLecturer(LecturerDto lecturerDto);
    void editLecturer(LecturerDto lecturerDto);
    void deleteLecturer(UUID id);
}
