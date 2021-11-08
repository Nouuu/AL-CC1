package org.larrieulacoste.noe.al.infrastructure.repository;

import org.larrieulacoste.noe.al.domain.entity.User;
import org.larrieulacoste.noe.al.domain.entity.UserId;
import org.larrieulacoste.noe.al.domain.repository.UserRepository;

public class JdbcUserRepository implements UserRepository {
    @Override
    public void save(User user) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public User byId(UserId userId) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public UserId nextId() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
