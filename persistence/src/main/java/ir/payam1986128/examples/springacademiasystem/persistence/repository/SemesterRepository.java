package ir.payam1986128.examples.springacademiasystem.persistence.repository;

import ir.payam1986128.examples.springacademiasystem.persistence.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, UUID> {
}
