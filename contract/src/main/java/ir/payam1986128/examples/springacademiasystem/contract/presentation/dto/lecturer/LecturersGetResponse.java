package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.lecturer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LecturersGetResponse {
    private List<LecturerDto> lecturers;
    private long total;
}
