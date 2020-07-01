package mk.ukim.finki.emt.reservation.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import mk.ukim.finki.emt.reservation.domain.model.BookId;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;

import java.time.Instant;

public class BookReturned implements DomainEvent {

    @JsonProperty("bookId")
    private final BookId bookId;
    @JsonProperty("reservationId")
    private final ReservationId reservationId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public BookReturned(@JsonProperty("reservationId") @NonNull ReservationId reservationId,
                        @JsonProperty("bookId") @NonNull BookId bookId,
                        @JsonProperty("occurredOn") @NonNull Instant occurredOn) {
        this.bookId = bookId;
        this.reservationId = reservationId;
        this.occurredOn = occurredOn;
    }


    @NonNull
    public ReservationId reservationId() {
        return reservationId;
    }

    @NonNull
    public BookId bookId() {
        return bookId;
    }

    @Override
    public @lombok.NonNull Instant occurredOn() {
        return this.occurredOn;
    }
}
