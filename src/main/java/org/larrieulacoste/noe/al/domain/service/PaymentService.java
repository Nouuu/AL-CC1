package org.larrieulacoste.noe.al.domain.service;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.LoggerFactory;
import org.larrieulacoste.noe.al.domain.entity.User;
import org.larrieulacoste.noe.al.domain.event.Subscriber;
import org.larrieulacoste.noe.al.domain.event.UserApplicationEvent;

import java.util.Objects;

public class PaymentService implements Subscriber<UserApplicationEvent> {
    private final Logger logger;

    public PaymentService(LoggerFactory loggerFactory) {
        this.logger = Objects.requireNonNull(loggerFactory).getLogger(this);
    }

    public void processPayment(User user) {
        logger.log("Process user payment of : " + user);
    }

    @Override
    public void accept(UserApplicationEvent userApplicationEvent) {
        this.processPayment(userApplicationEvent.getUser());
    }

}
