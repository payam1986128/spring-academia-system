package ir.payam1986128.examples.springacademiasystem.contract.business;

import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.AuthRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.AuthResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth.RefreshTokenResponse;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserRequest;
import ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.user.CreateUserResponse;

public interface AuthServiceApi {
    CreateUserResponse createUser(CreateUserRequest user);
    AuthResponse login(AuthRequest request);
    RefreshTokenResponse refreshToken(String refreshToken);
}
