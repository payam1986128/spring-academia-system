package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentNumberDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.StudentNumber;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.StudentNumberRepository;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class StudentNumberDao implements StudentNumberDaoApi {
    private StudentNumberRepository repository;

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public String generateStudentNumber() {
        int year = LocalDateTime.now().getYear() % 100;

        StudentNumber studentNumberSeq = repository.findById(year)
                .orElseGet(() -> StudentNumber.builder()
                        .year(year)
                        .lastNumber(0)
                        .build());

        int nextNumber = studentNumberSeq.getLastNumber() + 1;
        studentNumberSeq.setLastNumber(nextNumber);

        repository.save(studentNumberSeq);

        return String.format("%02d%04d", year, nextNumber);
    }
}
