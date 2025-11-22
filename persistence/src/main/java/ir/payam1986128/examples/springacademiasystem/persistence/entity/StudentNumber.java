package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_number")
public class StudentNumber {
    @Id
    private Integer year;
    private Integer lastNumber;
}
