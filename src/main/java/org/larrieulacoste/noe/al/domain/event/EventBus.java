package org.larrieulacoste.noe.al.domain.event;

import java.util.List;

public interface EventBus<E extends Event> {
    void send(E event);

    void registerSubscriber(Class<E> eventClass, Subscriber<E> subscriber);
}
