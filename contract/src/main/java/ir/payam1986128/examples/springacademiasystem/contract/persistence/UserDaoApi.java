package ir.payam1986128.examples.springacademiasystem.contract.persistence;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserDaoApi {
    Optional<UserDto> findByUsername(String username);
    UUID save(UserDto user);
}
