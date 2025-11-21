package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentsDto {
    private List<StudentDto> students;
    private long total;
}
