package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.enrollment;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.offer.OfferDto;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EnrollmentDto {
    private UUID id;
    private StudentDto student;
    private OfferDto offer;
}
