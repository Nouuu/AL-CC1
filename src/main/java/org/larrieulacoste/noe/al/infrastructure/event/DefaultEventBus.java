package org.larrieulacoste.noe.al.infrastructure.event;

import org.larrieulacoste.noe.al.domain.Logger;
import org.larrieulacoste.noe.al.domain.LoggerFactory;
import org.larrieulacoste.noe.al.domain.event.Event;
import org.larrieulacoste.noe.al.domain.event.EventBus;
import org.larrieulacoste.noe.al.domain.event.Subscriber;

import java.util.*;

public class DefaultEventBus<E extends Event> implements EventBus<E> {

    private final Map<Class<E>, List<Subscriber<E>>> subscribers;
    private final Logger logger;

    public DefaultEventBus(LoggerFactory loggerFactory) {
        this.subscribers = new HashMap<>();
        this.logger = Objects.requireNonNull(loggerFactory).getLogger(this);
    }

    @Override
    public void send(E event) {
        logger.log("New event sent : " + event);
        List<Subscriber<E>> eventSubscribers = this.subscribers.get(event.getClass());
        if (eventSubscribers == null || eventSubscribers.isEmpty()) {
            throw new IllegalStateException("No subscriber for " + event.getClass().getSimpleName());
        }
        eventSubscribers.forEach(subscriber -> subscriber.accept(event));
    }

    @Override
    public void registerSubscriber(Class<E> eventClass, Subscriber<E> givenSubscriber) {
        if (subscribers.containsKey(eventClass)) {
            List<Subscriber<E>> eventSubscribers = subscribers.get(eventClass);
            if (!eventSubscribers.contains(givenSubscriber)) {
                eventSubscribers.add(givenSubscriber);
            }
        } else {
            subscribers.put(eventClass, new ArrayList<>(List.of(givenSubscriber)));
        }
    }
}
