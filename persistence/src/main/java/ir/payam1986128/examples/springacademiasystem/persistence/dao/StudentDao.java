package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentFilterDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentsDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.Student;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.QStudent;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.StudentPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class StudentDao implements StudentDaoApi {

    private final StudentRepository repository;
    private final StudentPersistenceMapper mapper;

    @Override
    public Optional<StudentDto> getStudent(UUID id) {
        Optional<Student> optionalStudent = repository.findById(id);
        return optionalStudent.map(mapper::toStudentDto);
    }

    @Override
    public Optional<StudentDto> getStudent(String studentNumber) {
        Optional<Student> student = repository.findByStudentNumber(studentNumber);
        return student.map(mapper::toStudentDto);
    }

    @Override
    public StudentsDto getStudents(StudentFilterDto filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage()-1, filter.getPageSize());
        if (filter.getSort() != null && filter.getSortDirection() != null) {
            pageRequest.withSort(Sort.Direction.valueOf(filter.getSortDirection().name()), filter.getSort());
        }
        BooleanExpression predicate = QStudent.student.firstName.like("%"+filter.getFirstName()+"%");
        predicate = predicate.and(QStudent.student.lastName.like("%"+filter.getLastName()+"%"));
        if (filter.getStudentNumber() != null) {
            predicate = predicate.and(QStudent.student.studentNumber.eq(filter.getStudentNumber()));
        }
        Page<Student> studentsPage = repository.findAll(predicate, pageRequest);
        return StudentsDto.builder()
                .students(mapper.toStudentsDto(studentsPage.getContent()))
                .total(studentsPage.getTotalElements())
                .build();
    }

    @Override
    public UUID addStudent(StudentDto studentDto) {
        Student student = mapper.toStudent(studentDto);
        repository.save(student);
        return student.getId();
    }

    @Override
    public void editStudent(StudentDto studentDto) {
        repository.save(mapper.toStudent(studentDto));
    }

    @Override
    public void deleteStudent(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isStudentExist(UUID id) {
        return repository.existsById(id);
    }
}
