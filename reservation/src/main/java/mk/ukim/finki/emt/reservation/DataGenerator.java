package mk.ukim.finki.emt.reservation;

import mk.ukim.finki.emt.reservation.application.BookCatalog;
import mk.ukim.finki.emt.reservation.application.ReservationCatalog;
import mk.ukim.finki.emt.reservation.application.form.ReservationForm;
import mk.ukim.finki.emt.reservation.domain.model.*;
import mk.ukim.finki.emt.sharedkernel.infra.eventlog.DomainEventLogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final BookCatalog bookRepository;
    private final ReservationCatalog reservationRepository;

    public DataGenerator(BookCatalog bookRepository, ReservationCatalog reservationRepository) {
        this.bookRepository = bookRepository;
        this.reservationRepository = reservationRepository;
    }

    public void generateData(){
        var books = bookRepository.findAll();
        var reservation = reservationRepository.createReservation(makeReservation(books.get(0).getId(), new UserId("1")));
    }

    private ReservationForm makeReservation(BookId bookId, UserId userId){
        return new ReservationForm(bookId, userId, new DateTaking(LocalDate.now()));
    }

    @Override
    public void run(String... args) throws Exception {
        generateData();
    }
}
