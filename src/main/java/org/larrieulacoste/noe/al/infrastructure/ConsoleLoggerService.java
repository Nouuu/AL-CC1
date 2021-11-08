package org.larrieulacoste.noe.al.infrastructure;

import org.larrieulacoste.noe.al.domain.LoggerService;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConsoleLoggerService implements LoggerService {
    private static final Logger LOGGER = Logger.getLogger(ConsoleLoggerService.class.getName());

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
