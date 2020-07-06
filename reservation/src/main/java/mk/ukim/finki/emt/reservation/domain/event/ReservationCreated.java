package mk.ukim.finki.emt.reservation.domain.event;

/* vo specifikacijata potpisan kako BookReservedEvent*/

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.reservation.domain.model.BookId;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;
import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class ReservationCreated implements DomainEvent {

    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("bookId")
    private final BookId bookId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator
    public ReservationCreated(ReservationId reservationId,
                              BookId bookId,
                              Instant occurredOn) {
        this.reservationId = Objects.requireNonNull(reservationId, "reservationId must not be null");
        this.bookId = Objects.requireNonNull(bookId, "bookId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }


    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}
