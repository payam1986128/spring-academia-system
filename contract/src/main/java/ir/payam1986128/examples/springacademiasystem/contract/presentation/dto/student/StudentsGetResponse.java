package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.student;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentsGetResponse {
    private List<StudentDto> students;
    private long total;
}
