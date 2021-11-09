package org.larrieulacoste.noe.al.infrastructure.repository;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.LoggerFactory;
import org.larrieulacoste.noe.al.domain.entity.User;
import org.larrieulacoste.noe.al.domain.entity.UserId;
import org.larrieulacoste.noe.al.domain.repository.UserRepository;

import java.util.Objects;

public class JdbcUserRepository implements UserRepository {
    private final Logger logger;

    public JdbcUserRepository(LoggerFactory loggerFactory) {
        this.logger = Objects.requireNonNull(loggerFactory).getLogger(this);
        this.logger.error("Warning !!! Your are instancing a not yet implemented repository");
    }

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
