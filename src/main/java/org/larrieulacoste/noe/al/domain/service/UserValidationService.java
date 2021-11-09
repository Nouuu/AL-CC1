package org.larrieulacoste.noe.al.domain.service;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.LoggerFactory;
import org.larrieulacoste.noe.al.domain.entity.User;

import java.util.Objects;

public class UserValidationService {
    private final Logger logger;

    public UserValidationService(LoggerFactory loggerFactory) {
        this.logger = Objects.requireNonNull(loggerFactory).getLogger(this);
    }

    public Boolean isUserValid(User user) {
        logger.log("Trigerred validation with user : " + user);
        // TODO fill this method correctly
        return true;
    }
}
