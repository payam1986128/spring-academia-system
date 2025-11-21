package ir.payam1986128.examples.springacademiasystem.persistence.mapper;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.UserDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
