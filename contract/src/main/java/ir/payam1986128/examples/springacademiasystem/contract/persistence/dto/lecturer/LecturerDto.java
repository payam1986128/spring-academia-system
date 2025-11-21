package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LecturerDto {
    private UUID id;
    private String firstName;
    private String lastName;
}
