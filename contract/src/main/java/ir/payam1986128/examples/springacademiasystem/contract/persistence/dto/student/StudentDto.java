package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StudentDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String studentNumber;
}
