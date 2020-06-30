package mk.ukim.finki.emt.bookcatalog.integration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import mk.ukim.finki.emt.bookcatalog.domain.model.BookId;
import mk.ukim.finki.emt.bookcatalog.domain.model.ReservationId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;
import java.util.Objects;

public class BookReturnedEvent implements DomainEvent {

    @JsonProperty("bookId")
    private final BookId bookId;
    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator
    public BookReturnedEvent(@JsonProperty("bookId") @NonNull BookId bookId,
                             @JsonProperty("reservationId") @NonNull ReservationId reservationId,
                             @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.bookId = Objects.requireNonNull(bookId, "bookId must not be null");
        this.reservationId = reservationId;
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }


    @Override
    public @NonNull Instant occurredOn() {
        return occurredOn;
    }
}
