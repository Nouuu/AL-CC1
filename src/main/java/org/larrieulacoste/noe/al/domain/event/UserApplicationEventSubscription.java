package org.larrieulacoste.noe.al.domain.event;

import org.larrieulacoste.noe.al.domain.service.PaymentService;

public class UserApplicationEventSubscription implements Subscriber<UserApplicationEvent> {
    private final PaymentService paymentService;

    public UserApplicationEventSubscription(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void accept(UserApplicationEvent userApplicationEvent) {
        paymentService.processPayment(userApplicationEvent.getUser());
    }
}
