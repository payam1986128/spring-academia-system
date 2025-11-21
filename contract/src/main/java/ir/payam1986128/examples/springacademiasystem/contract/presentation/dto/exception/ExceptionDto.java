package ir.payam1986128.examples.springacademiasystem.contract.presentation.dto.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public class ExceptionDto {
    private final String code;
    private final String description;
    private Map<String, String> params;

    public ExceptionDto(String code, String description, Map<String, String> params) {
        this.code = code;
        this.description = description;
        this.params = params;
    }
}
