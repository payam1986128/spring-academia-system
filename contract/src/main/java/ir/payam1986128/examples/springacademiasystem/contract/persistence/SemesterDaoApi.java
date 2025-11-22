package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;

import java.util.Optional;
import java.util.UUID;

public interface SemesterDaoApi {
    Optional<SemesterDto> getSemester(UUID id);
    Optional<SemesterDto> getCurrentSemester();
    UUID addSemester(SemesterDto semesterDto);
    void editSemester(SemesterDto semesterDto);
    void deleteSemester(UUID id);
    boolean isSemesterExist(UUID id);
}
