package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @JoinColumn(name = "course_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @JoinColumn(name = "lecturer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lecturer lecturer;

    @JoinColumn(name = "semester_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Semester semester;

    private int capacity;

    private int registered;

    @Version
    private int version;
}
