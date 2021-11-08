package org.larrieulacoste.noe.al.infrastructure.event;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.event.Event;
import org.larrieulacoste.noe.al.domain.event.EventBus;
import org.larrieulacoste.noe.al.domain.event.Subscriber;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LoggedDefaultEventBus<E extends Event> implements EventBus<E> {

    private final Map<Class<E>, List<Subscriber<E>>> subscribers;
    private Logger logger;

    public LoggedDefaultEventBus(Map<Class<E>, List<Subscriber<E>>> subscribers, Logger logger) {
        this.subscribers = Objects.requireNonNull(subscribers);
        this.logger = Objects.requireNonNull(logger);
    }

    @Override
    public void send(E event) {
        logger.log("New event sent : " + event);
        final List<Subscriber<E>> eventSubscribers = this.subscribers.get(event.getClass());
        if (eventSubscribers == null || eventSubscribers.isEmpty()) {
            throw new IllegalStateException("No subscriber for " + event.getClass().getSimpleName());
        }
        eventSubscribers.forEach(subscriber -> subscriber.accept(event));
    }

    @Override
    public void registerSubscriber(Class<E> classE, List<Subscriber<E>> givenSubscribers) {
        subscribers.putIfAbsent(classE, givenSubscribers);
    }
}
