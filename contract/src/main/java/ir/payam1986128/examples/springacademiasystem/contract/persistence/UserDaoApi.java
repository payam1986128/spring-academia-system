package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.enumeration.Role;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDaoApi {
    Optional<UserDto> findByUsername(String username);
    List<UserDto> findAllByRole(Role role);
    UUID save(UserDto user);
}
