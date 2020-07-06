package mk.ukim.finki.emt.finemanagement.application;

import lombok.NonNull;
import mk.ukim.finki.emt.finemanagement.domain.model.Fine;
import mk.ukim.finki.emt.finemanagement.domain.model.FineDescription;
import mk.ukim.finki.emt.finemanagement.domain.model.FineId;
import mk.ukim.finki.emt.finemanagement.domain.model.Price;
import mk.ukim.finki.emt.finemanagement.domain.repository.FineRepository;
import mk.ukim.finki.emt.finemanagement.integration.ReservationExpiredEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class FineCatalog {

    private final FineRepository fineRepository;

    public FineCatalog(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
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
    public void onBookReturnedEvent(ReservationExpiredEvent reservationExpiredEvent){
        Fine fine = new Fine(new Price(1000),
                new FineDescription("Fine for expired reservation " + reservationExpiredEvent.getReservationId()),
                false, reservationExpiredEvent.getUserId(), reservationExpiredEvent.getReservationId());
        fineRepository.save(fine);
    }


}
