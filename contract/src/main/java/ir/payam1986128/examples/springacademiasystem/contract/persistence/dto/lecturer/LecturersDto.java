package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.lecturer;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LecturersDto {
    private List<LecturerDto> lecturers;
    private long total;
}
