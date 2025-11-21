package ir.payam1986128.examples.springacademiasystem.business.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.UserDetailsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserBusinessMapper {
    UserDto toUserDto(CreateUserRequest createUserRequest);
    UserDetailsDto toUserDetailsDto(UserDto userDto);
}
