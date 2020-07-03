package mk.ukim.finki.emt.reservation.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class ReservationExpired implements DomainEvent {

    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    //treba user ili fine?

    @JsonCreator
    public ReservationExpired(@JsonProperty("reservationId") @NonNull ReservationId reservationId,
                              @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.reservationId = Objects.requireNonNull(reservationId, "reservationId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public ReservationId reservationId() {
        return reservationId;
    }


    @Override
    @NonNull
    public Instant occurredOn() {
        return occurredOn;
    }
}


