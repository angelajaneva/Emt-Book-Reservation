package mk.ukim.finki.emt.bookcatalog.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.bookcatalog.domain.model.BookId;
import mk.ukim.finki.emt.bookcatalog.domain.model.ReservationId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;

public class ReservationCreatedEvent implements DomainEvent {


    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("bookId")
    private final BookId bookId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator
    public ReservationCreatedEvent(@JsonProperty("reservationId") @NonNull ReservationId reservationId,
                              @JsonProperty("bookId") @NonNull BookId bookId,
                              @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.reservationId = Objects.requireNonNull(reservationId, "reservationId must not be null");
        this.bookId = Objects.requireNonNull(bookId, "bookId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @NonNull
    public ReservationId reservationId() {
        return reservationId;
    }


    @Override
    public Instant occurredOn() {
        return null;
    }

}
