package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.StudentNumberDaoApi;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.StudentNumber;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.StudentNumberRepository;
import jakarta.persistence.LockModeType;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class StudentNumberDao implements StudentNumberDaoApi {
    private StudentNumberRepository repository;

    @Override
    @Retryable(
            retryFor = Exception.class, // It should be OptimisticLockException but H2 doesn't support that
            maxAttempts = 10,
            backoff = @Backoff(delay = 50)
    )
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
    public String generateStudentNumber() {
        int year = LocalDateTime.now().getYear() % 100;

        StudentNumber studentNumberSeq = repository.findById(year)
                .orElseGet(() -> StudentNumber.builder()
                        .registeredYear(year)
                        .lastNumber(0)
                        .build());

        int nextNumber = studentNumberSeq.getLastNumber() + 1;
        studentNumberSeq.setLastNumber(nextNumber);

        repository.save(studentNumberSeq);

        return String.format("%02d%04d", year, nextNumber);
    }
}
