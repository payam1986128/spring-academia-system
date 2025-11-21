package ir.payam1986128.examples.springacademiasystem.business.mapper;

import java.util.UUID;

public interface CommonBusinessMapper {
    default String toString(UUID source) {
        return source.toString();
    }
    default UUID toUUID(String source) {
        return UUID.fromString(source);
    }
}
