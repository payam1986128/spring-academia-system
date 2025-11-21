package ir.payam1986128.examples.springacademiasystem.business.service;

import ir.payam1986128.examples.springacademiasystem.business.exception.InvalidRefreshTokenException;
import ir.payam1986128.examples.springacademiasystem.business.exception.UserAlreadyExistsException;
import ir.payam1986128.examples.springacademiasystem.business.exception.UserNotFoundException;
import ir.payam1986128.examples.springacademiasystem.business.mapper.UserBusinessMapper;
import ir.payam1986128.examples.springacademiasystem.contract.business.AuthServiceApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.UserDaoApi;
import ir.payam1986128.examples.springacademiasystem.contract.persistence.dto.user.UserDto;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.AuthRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.AuthResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.RefreshTokenResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.UserDetailsDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService implements AuthServiceApi {

    private final AuthenticationManager authenticationManager;
    private final UserDaoApi userDao;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;
    private final UserBusinessMapper userMapper;

    private UserDetailsDto getUserDetails(String username) {
        UserDto userDto = userDao.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
        return userMapper.toUserDetailsDto(userDto);
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest user) {
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UUID savedId = userDao.save(userMapper.toUserDto(user));
        return new CreateUserResponse(savedId.toString());
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsDto user = getUserDetails(request.getUsername());

        String accessToken = jwtTokenService.generateAccessToken(user);
        String refreshToken = jwtTokenService.generateRefreshToken(user);

        return new AuthResponse(accessToken, refreshToken);
    }

    @Override
    public RefreshTokenResponse refreshToken(String refreshToken) {
        String username = jwtTokenService.getUsernameFromToken(refreshToken);
        UserDetailsDto user = getUserDetails(username);

        if (!jwtTokenService.isValidRefreshToken(refreshToken, user.getUsername())) {
            throw new InvalidRefreshTokenException();
        }

        String newAccessToken = jwtTokenService.generateAccessToken(user);
        return new RefreshTokenResponse(newAccessToken);
    }
}
