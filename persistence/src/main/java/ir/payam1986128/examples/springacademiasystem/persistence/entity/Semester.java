package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "semester", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueTitle", columnNames = "title")
})
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}
