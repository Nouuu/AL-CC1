package org.larrieulacoste.noe.al.domain.event;

import org.larrieulacoste.noe.al.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.Objects;

public class UserApplicationEvent implements Event<User> {

    private final EventId eventId;
    private final ZonedDateTime occurredDate;
    private final User user;

    private UserApplicationEvent(EventId eventId, ZonedDateTime occurredDate, User user) {
        this.eventId = Objects.requireNonNull(eventId);
        this.occurredDate = Objects.requireNonNull(occurredDate);
        this.user = Objects.requireNonNull(user);
    }

    public static UserApplicationEvent withUser(User user) {
        return new UserApplicationEvent(EventId.create(), ZonedDateTime.now(), user);
    }

    @Override
    public EventId getId() {
        return eventId;
    }

    @Override
    public ZonedDateTime getOccurredDate() {
        return occurredDate;
    }

    @Override
    public User getItem() {
        return user;
    }

    @Override
    public String toString() {
        return "UserApplicationEvent{" +
                "eventId=" + eventId +
                ", occurredDate=" + occurredDate +
                ", user=" + user +
                '}';
    }
}
