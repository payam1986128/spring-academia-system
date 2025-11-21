package ir.payam1986128.examples.springacademiasystem.persistence.repository;

import ir.payam1986128.examples.springacademiasystem.persistence.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, UUID> {
}
