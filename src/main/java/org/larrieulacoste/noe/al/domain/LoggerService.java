package org.larrieulacoste.noe.al.domain;

public interface LoggerService {
    void log(String message);

    void error(String message);
}
