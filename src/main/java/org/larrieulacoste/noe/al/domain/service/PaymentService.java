package org.larrieulacoste.noe.al.domain.service;

import org.larrieulacoste.noe.al.domain.api.PaymentAPI;
import org.larrieulacoste.noe.al.domain.entity.User;
import org.larrieulacoste.noe.al.domain.event.Subscriber;
import org.larrieulacoste.noe.al.domain.event.UserApplicationEvent;
import org.larrieulacoste.noe.al.domain.exception.PaymentException;
import org.larrieulacoste.noe.al.domain.logger.Logger;
import org.larrieulacoste.noe.al.domain.logger.LoggerFactory;

import java.util.Objects;

public class PaymentService implements Subscriber<UserApplicationEvent> {
    private final Logger logger;
    private final PaymentAPI paymentAPI;

    public PaymentService(LoggerFactory loggerFactory, PaymentAPI paymentAPI) {
        this.logger = Objects.requireNonNull(loggerFactory).getLogger(this);
        this.paymentAPI = paymentAPI;
    }

    public void processPayment(User user, Double amount) throws PaymentException {
        logger.log("Process user payment of : " + user);
        Boolean result = paymentAPI.pay(Objects.requireNonNull(user).getBankAccount(), amount);
        if (!Boolean.TRUE.equals(result)) {
            throw new PaymentException("Payment error for user : " + user);
        }
    }

    @Override
    public void accept(UserApplicationEvent userApplicationEvent) {
        this.processPayment(userApplicationEvent.getItem(), 0.);
    }

}
