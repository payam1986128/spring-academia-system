package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueNumber", columnNames = "studentNumber")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String studentNumber;
}
