package org.larrieulacoste.noe.al.domain.entity;

import java.util.Objects;
import java.util.UUID;

public class UserId {
    private final String value;

    private UserId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UserId fromUUID(UUID uuid) {
        return new UserId(uuid.toString());
    }

    public static UserId of(String value) {
        return new UserId(Objects.requireNonNull(value));
    }

    @Override
    public String toString() {
        return "UserId{" +
                "value='" + value + '\'' +
                '}';
    }
}
