package mk.ukim.finki.emt.finemanagement.application;

import lombok.NonNull;
import mk.ukim.finki.emt.finemanagement.domain.event.FineCreated;
import mk.ukim.finki.emt.finemanagement.domain.model.Fine;
import mk.ukim.finki.emt.finemanagement.domain.model.FineDescription;
import mk.ukim.finki.emt.finemanagement.domain.model.FineId;
import mk.ukim.finki.emt.finemanagement.domain.model.Price;
import mk.ukim.finki.emt.finemanagement.domain.repository.FineRepository;
import mk.ukim.finki.emt.finemanagement.integration.ReservationExpiredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FineCatalog {

    private final FineRepository fineRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    public FineCatalog(FineRepository fineRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.fineRepository = fineRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @NonNull
    public List<Fine> findAll(){
        return fineRepository.findAll();
    }

    @NonNull
    public Fine findById(@NonNull FineId fineId){
        Objects.requireNonNull(fineId, "fine id must not be null");
        return fineRepository.findById(fineId).orElseThrow(RuntimeException::new);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public FineId onBookReturnedEvent(ReservationExpiredEvent reservationExpiredEvent){
        var fine = fineRepository.saveAndFlush(toDomainModel(reservationExpiredEvent));
        applicationEventPublisher.publishEvent(new FineCreated(fine.getId(), fine.getUserId(), fine.getPrice(), Instant.now()));

        return fine.getId();
    }


    public Fine toDomainModel(ReservationExpiredEvent expiredEvent){

        return new Fine(new Price(1000),
                new FineDescription("Fine for expired reservation " + expiredEvent.getReservationId()),
                false, expiredEvent.getUserId(), expiredEvent.getReservationId());
    }
}
