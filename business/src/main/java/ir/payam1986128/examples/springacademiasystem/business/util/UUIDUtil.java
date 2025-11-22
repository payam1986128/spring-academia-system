package ir.payam1986128.examples.springacademiasystem.business.util;

import ir.payam1986128.examples.springacademiasystem.business.exception.InvalidUUIDException;

import java.util.UUID;

public class UUIDUtil {
    public static UUID parseId(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception e) {
            throw new InvalidUUIDException();
        }
    }
}
