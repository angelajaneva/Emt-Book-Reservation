package mk.ukim.finki.emt.bookcatalog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCreatedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    ReservationCreatedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public boolean supports(StoredDomainEvent remoteEvent) {
        return remoteEvent.domainEventClassName().equals("mk.ukim.finki.emt.reservation.domain.event.ReservationCreated");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, ReservationCreatedEvent.class));
    }
}
