package mk.ukim.finki.emt.usersubscription.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.usersubscription.domain.model.User.BookId;

import java.time.Instant;
import java.util.Objects;

public class BookReturned implements DomainEvent {

    @JsonProperty("bookId")
    private final BookId bookId;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;


    @JsonCreator
    public BookReturned(@JsonProperty("bookId") @org.springframework.lang.NonNull BookId bookId,
                        @JsonProperty("occurredOn") @org.springframework.lang.NonNull Instant occurredOn) {
        this.bookId = Objects.requireNonNull(bookId, "bookId must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }


    @Override
    public @NonNull Instant occurredOn() {
        return occurredOn;
    }
}
