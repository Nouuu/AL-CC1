package org.larrieulacoste.noe.al.infrastructure;

import org.larrieulacoste.noe.al.domain.Logger;

import java.util.Objects;
import java.util.logging.Level;

public class DefaultLogger implements Logger {
    private final java.util.logging.Logger logger;

    public DefaultLogger(String name) {
        this.logger = java.util.logging.Logger.getLogger(Objects.requireNonNull(name));
    }

    @Override
    public void log(String message) {
        logger.log(Level.INFO, message);
    }

    @Override
    public void error(String message) {
        logger.log(Level.WARNING, message);
    }
}
