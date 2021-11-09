package org.larrieulacoste.noe.al.infrastructure;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.LoggerFactory;

import java.util.Objects;

public final class DefaultLoggerFactory implements LoggerFactory {

    @Override
    public Logger getLogger(Object object) {
        return new DefaultLogger(Objects.requireNonNull(object).getClass().getName());
    }
}
