package mk.ukim.finki.emt.bookcatalog.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.bookcatalog.domain.model.BookId;
import mk.ukim.finki.emt.bookcatalog.domain.model.ReservationId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import lombok.NonNull;
import lombok.Getter;

import java.time.Instant;
import java.util.Objects;

@Getter
public class ReservationCreatedEvent implements DomainEvent {


    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("bookId")
    private final BookId bookId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator
    public ReservationCreatedEvent(ReservationId reservationId,
                              BookId bookId,
                              Instant occurredOn) {
        this.reservationId = Objects.requireNonNull(reservationId, "reservationId must not be null");
        this.bookId = Objects.requireNonNull(bookId, "bookId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @Override
    public Instant occurredOn() {
        return null;
    }

}
