package mk.ukim.finki.emt.finemanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.finemanagement.domain.model.FineId;
import mk.ukim.finki.emt.finemanagement.domain.model.Price;
import mk.ukim.finki.emt.finemanagement.domain.model.UserId;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;
import java.util.Objects;

@Getter
public class FineCreated implements DomainEvent {

    @JsonProperty("fineId")
    private final FineId fineId;
    @JsonProperty("userId")
    private final UserId userId;
    @JsonProperty("price")
    private final Price price;
    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public FineCreated(FineId fineId, UserId userId,
                       Price price, Instant occurredOn) {
        this.fineId = Objects.requireNonNull(fineId, "reservationId must not be null");
        this.userId = Objects.requireNonNull(userId, "bookId must not be null");
        this.price = Objects.requireNonNull(price, "Price must not be null");
        this.occurredOn = Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }

    @Override
    public @NonNull Instant occurredOn() {
        return null;
    }
}
