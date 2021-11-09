package org.larrieulacoste.noe.al.domain.service;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.LoggerFactory;
import org.larrieulacoste.noe.al.domain.entity.User;

import java.util.Objects;

public class PaymentService {
    private final Logger logger;

    public PaymentService(LoggerFactory loggerFactory) {
        this.logger = Objects.requireNonNull(loggerFactory).getLogger(this);
    }

    public void processPayment(User user) {
        logger.log("Process user payment of : " + user);
    }
}
