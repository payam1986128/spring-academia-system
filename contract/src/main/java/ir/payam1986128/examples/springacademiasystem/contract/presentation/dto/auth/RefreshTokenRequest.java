package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
}
