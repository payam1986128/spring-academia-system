package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "enrollment", uniqueConstraints = {
        @UniqueConstraint(
                name = "uniqueRegistration",
                columnNames = {"student_id", "offer_id"}
        )
})
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "student_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @JoinColumn(name = "offer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Offer offer;
}
