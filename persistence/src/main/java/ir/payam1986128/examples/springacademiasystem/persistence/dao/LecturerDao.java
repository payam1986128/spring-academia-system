package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.LecturerDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturerFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer.LecturersDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Lecturer;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.QLecturer;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.LecturerPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class LecturerDao implements LecturerDaoApi {

    private final LecturerRepository repository;
    private final LecturerPersistenceMapper mapper;

    @Override
    public Optional<LecturerDto> getLecturer(UUID id) {
        Optional<Lecturer> optionalLecturer = repository.findById(id);
        return optionalLecturer.map(mapper::toLecturerDto);
    }

    @Override
    public LecturersDto getLecturers(LecturerFilterDto filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage()-1, filter.getPageSize());
        if (filter.getSort() != null && filter.getSortDirection() != null) {
            pageRequest.withSort(Sort.Direction.valueOf(filter.getSortDirection().name()), filter.getSort());
        }
        BooleanExpression predicate = QLecturer.lecturer.firstName.like("%"+filter.getFirstName()+"%");
        predicate = predicate.and(QLecturer.lecturer.lastName.eq("%"+filter.getLastName()+"%"));
        Page<Lecturer> lecturersPage = repository.findAll(predicate, pageRequest);
        return LecturersDto.builder()
                .lecturers(mapper.toLecturersDto(lecturersPage.getContent()))
                .total(lecturersPage.getTotalElements())
                .build();
    }

    @Override
    public UUID addLecturer(LecturerDto lecturerDto) {
        Lecturer lecturer = mapper.toLecturer(lecturerDto);
        repository.save(lecturer);
        return lecturer.getId();
    }

    @Override
    public void editLecturer(UUID id, LecturerDto lecturerDto) {
        Lecturer lecturer = mapper.toLecturer(lecturerDto);
        lecturer.setId(id);
        repository.save(lecturer);
    }

    @Override
    public void deleteLecturer(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isLecturerExist(UUID id) {
        return repository.existsById(id);
    }
}
