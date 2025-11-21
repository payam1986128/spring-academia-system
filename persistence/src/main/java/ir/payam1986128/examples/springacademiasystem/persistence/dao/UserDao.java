package ir.payam1986128.examples.springacademiasystem.persistence.dao;

import ir.payam1986128.examples.springacademiasystem.contract.persistence.UserDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;
import ir.payam1986128.examples.springacademiasystem.persistence.entity.User;
import ir.payam1986128.examples.springacademiasystem.persistence.mapper.UserPersistenceMapper;
import ir.payam1986128.examples.springacademiasystem.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserDao implements UserDaoApi {

    private final UserRepository userRepository;
    private final UserPersistenceMapper userMapper;

    @Override
    public Optional<UserDto> findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.map(userMapper::toUserDto);
    }

    @Override
    public UUID save(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
        return user.getId();
    }
}
