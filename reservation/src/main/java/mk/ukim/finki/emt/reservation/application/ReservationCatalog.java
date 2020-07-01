package mk.ukim.finki.emt.reservation.application;

import lombok.NonNull;
import mk.ukim.finki.emt.reservation.application.form.ChangeReservationStatusForm;
import mk.ukim.finki.emt.reservation.application.form.ReservationForm;
import mk.ukim.finki.emt.reservation.domain.event.BookReturned;
import mk.ukim.finki.emt.reservation.domain.event.ReservationCreated;
import mk.ukim.finki.emt.reservation.domain.model.DateExpiring;
import mk.ukim.finki.emt.reservation.domain.model.Reservation;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import mk.ukim.finki.emt.reservation.domain.model.ReservationStatus;
import mk.ukim.finki.emt.reservation.domain.repository.ReservationRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ReservationCatalog {

    private final ReservationRepository reservationRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
//    private final Validator validator;
    private final BookCatalog bookCatalog;


    public ReservationCatalog(ReservationRepository reservationRepository, ApplicationEventPublisher applicationEventPublisher, BookCatalog bookCatalog) {
        this.reservationRepository = reservationRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.bookCatalog = bookCatalog;
    }

    public ReservationId createReservation(@NonNull ReservationForm reservationForm){
        Objects.requireNonNull(reservationForm,"reservation must not be null");

        var reservation = reservationRepository.saveAndFlush(toDomainModel(reservationForm));

        applicationEventPublisher.publishEvent(new ReservationCreated(reservation.getId(), reservation.getBookId(), Instant.now()));

        return reservation.getId();
    }

    @NonNull
    public Reservation findById(@NonNull ReservationId id){
        return reservationRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Reservation changeReservationStatus(@NonNull ChangeReservationStatusForm reservationForm){
        Objects.requireNonNull(reservationForm, "reservation must not be null");

        var reservation = reservationRepository.findById(reservationForm.getReservationId()).orElseThrow(RuntimeException::new);
        reservation.changeReservationStatus(reservationForm.getStatus());
        reservation = reservationRepository.saveAndFlush(reservation);
        //ako knigata e vratena da publikuvame event i da go zgolemime quantity na book
        if (reservation.getStatus() == ReservationStatus.Returned){
            applicationEventPublisher.publishEvent(new BookReturned(reservation.getId(), reservation.getBookId(), Instant.now()));
        }
        else if (reservation.getStatus() == ReservationStatus.Expired){
            //ovde treba si fine event da se publikuva
        }
        return reservation;
    }

    private Reservation toDomainModel(ReservationForm reservationForm){
        //1 mesec vreme za vrakjanje
        var expiringDate = new DateExpiring(reservationForm.getDateTakingReservation().getDateTaking().plusMonths(1L));
        //preku bookCatalog se prave povik kon modulot za book
        var bookId = bookCatalog.findById(reservationForm.getBookId()).getId();
        return new Reservation(ReservationStatus.Processing, bookId, reservationForm.getUserId(), expiringDate, reservationForm.getDateTakingReservation());
    }

}
