package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.semester;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SemesterGetResponse {
    private String id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
}
