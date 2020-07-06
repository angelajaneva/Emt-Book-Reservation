package mk.ukim.finki.emt.reservation.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import mk.ukim.finki.emt.reservation.domain.model.UserId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

@Getter
public class ReservationExpired implements DomainEvent {

    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;
    @JsonProperty("userId")
    private final UserId userId;

    @JsonCreator
    public ReservationExpired(ReservationId reservationId, Instant occurredOn,
                              UserId userId) {
        this.reservationId = Objects.requireNonNull(reservationId, "reservationId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
        this.userId = Objects.requireNonNull(userId, "userId must not be null");
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}


