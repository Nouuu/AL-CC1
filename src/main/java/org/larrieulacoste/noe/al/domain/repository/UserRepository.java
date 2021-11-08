package org.larrieulacoste.noe.al.domain.repository;

import org.larrieulacoste.noe.al.domain.entity.User;
import org.larrieulacoste.noe.al.domain.entity.UserId;

import java.util.UUID;

public interface UserRepository {

    void save(User user);

    User byId(UserId userId);

    default UserId nextId() {
        return UserId.fromUUID(UUID.randomUUID());
    }
}
