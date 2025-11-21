package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.semester;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class SemesterDto {
    private UUID id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}
