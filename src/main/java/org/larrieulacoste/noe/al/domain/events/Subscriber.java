package org.larrieulacoste.noe.al.domain.events;

import java.util.function.Consumer;

public interface Subscriber<E extends Event> extends Consumer<E> {
}
