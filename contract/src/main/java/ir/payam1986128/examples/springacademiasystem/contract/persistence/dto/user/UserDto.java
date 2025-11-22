package ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user;

import ir.payam1986128.examples.springacademiasystem.contract.enumeration.Role;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.student.StudentDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
    private StudentDto student;
}
