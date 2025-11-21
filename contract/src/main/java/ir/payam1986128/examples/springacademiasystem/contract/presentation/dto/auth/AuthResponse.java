package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
}
