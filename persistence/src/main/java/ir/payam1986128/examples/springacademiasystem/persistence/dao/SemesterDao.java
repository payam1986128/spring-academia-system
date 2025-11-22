package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.SemesterDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester.SemesterDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Semester;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.SemesterPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.SemesterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class SemesterDao implements SemesterDaoApi {

    private final SemesterRepository repository;
    private final SemesterPersistenceMapper mapper;

    @Override
    public Optional<SemesterDto> getSemester(UUID id) {
        Optional<Semester> optionalSemester = repository.findById(id);
        return optionalSemester.map(mapper::toSemesterDto);
    }

    @Override
    public Optional<SemesterDto> getCurrentSemester() {
        Optional<Semester> optionalSemester = repository.findByStartDateBeforeAndEndDateAfter(LocalDateTime.now());
        return optionalSemester.map(mapper::toSemesterDto);
    }

    @Override
    public UUID addSemester(SemesterDto semesterDto) {
        Semester semester = mapper.toSemester(semesterDto);
        repository.save(semester);
        return semester.getId();
    }

    @Override
    public void editSemester(SemesterDto semesterDto) {
        repository.save(mapper.toSemester(semesterDto));
    }

    @Override
    public void deleteSemester(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isSemesterExist(UUID id) {
        return repository.existsById(id);
    }
}
