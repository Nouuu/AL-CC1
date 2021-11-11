package org.larrieulacoste.noe.al;


import org.larrieulacoste.noe.al.domain.entity.User;
import org.larrieulacoste.noe.al.domain.event.user.UserApplicationEvent;
import org.larrieulacoste.noe.al.domain.event.user.UserApplicationEventSubscription;
import org.larrieulacoste.noe.al.domain.service.PaymentService;
import org.larrieulacoste.noe.al.domain.service.UserApplicationService;
import org.larrieulacoste.noe.al.domain.service.UserValidationService;
import org.larrieulacoste.noe.al.infrastructure.DefaultLoggerFactory;
import org.larrieulacoste.noe.al.infrastructure.event.DefaultEventBus;
import org.larrieulacoste.noe.al.infrastructure.repository.InMemoryUserRepository;

public class App {
    public static void main(String[] args) {
        var loggerFactory = new DefaultLoggerFactory();


        var userRepository = new InMemoryUserRepository(loggerFactory);
        var eventBus = new DefaultEventBus(loggerFactory);
        var userValidationService = new UserValidationService(loggerFactory);
        var userApplicationService = new UserApplicationService(eventBus, loggerFactory, userRepository, userValidationService);
        var paymentService = new PaymentService(loggerFactory);

        var userApplicationEventSubscription = new UserApplicationEventSubscription(paymentService);
        eventBus.registerSubscriber(UserApplicationEvent.class, userApplicationEventSubscription);

        var user = User.of(userRepository.nextId(), "larrieu", "noé", "noe@mail.com", "changeme", "111-332");
        userApplicationService.applyForMembership(user);

        System.out.println(userRepository.byId(user.getUserId()));
    }
}
