package ir.payam1986128.examples.springacademiasystem.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
    private Integer registeredYear;

    private Integer lastNumber;

    @Version
    private int version;
}
