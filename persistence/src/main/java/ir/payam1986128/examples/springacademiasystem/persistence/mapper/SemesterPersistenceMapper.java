package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Semester;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemesterPersistenceMapper {
    SemesterDto toSemesterDto(Semester semester);
    Semester toSemester(SemesterDto semesterDto);
}
