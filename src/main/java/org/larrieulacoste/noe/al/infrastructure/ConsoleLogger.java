package org.larrieulacoste.noe.al.infrastructure;

import org.larrieulacoste.noe.al.domain.Logger;

import java.util.logging.Level;

public final class ConsoleLogger implements Logger {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ConsoleLogger.class.getName());

    @Override
    public void log(String message) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, message);
        }
    }

    @Override
    public void error(String message) {
        if (LOGGER.isLoggable(Level.SEVERE)) {
            LOGGER.log(Level.SEVERE, message);
        }
    }
}
