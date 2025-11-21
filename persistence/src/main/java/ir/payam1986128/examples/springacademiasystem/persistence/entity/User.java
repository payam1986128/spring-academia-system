package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import ir.payam1986128.examples.springacademiasystem.contract.enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sas_user", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueUsername", columnNames = "username")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    private Role role;

    @JoinColumn(name = "student_id")
    @ManyToOne
    private Student student;
}
