package mk.ukim.finki.emt.reservation;

import mk.ukim.finki.emt.reservation.application.BookCatalog;
import mk.ukim.finki.emt.reservation.application.ReservationCatalog;
import mk.ukim.finki.emt.reservation.application.form.ReservationForm;
import mk.ukim.finki.emt.reservation.domain.model.*;
import mk.ukim.finki.emt.reservation.domain.repository.ReservationRepository;
import mk.ukim.finki.emt.reservation.port.client.BookCatalogClient;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class DataGenerator {

    private final BookCatalog bookRepository;
    private final ReservationCatalog reservationRepository;

    public DataGenerator(BookCatalog bookRepository, ReservationCatalog reservationRepository) {
        this.bookRepository = bookRepository;
        this.reservationRepository = reservationRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData(){
        var books = bookRepository.findAll();
        var reservation = reservationRepository.createReservation(makeReservation(books.get(0).getBookId(), new UserId("1")));
        System.out.println(reservation);
    }

    private ReservationForm makeReservation(BookId bookId, UserId userId){
        return new ReservationForm(bookId, userId, new DateTaking(LocalDate.now()));
    }

}
