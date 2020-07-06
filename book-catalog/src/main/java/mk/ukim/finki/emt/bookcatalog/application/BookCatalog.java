package mk.ukim.finki.emt.bookcatalog.application;

import lombok.NonNull;
import mk.ukim.finki.emt.bookcatalog.domain.model.Book;
import mk.ukim.finki.emt.bookcatalog.domain.model.BookId;
import mk.ukim.finki.emt.bookcatalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.bookcatalog.integration.BookReturnedEvent;
import mk.ukim.finki.emt.bookcatalog.integration.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class BookCatalog {

    private final BookRepository bookRepository;

    public BookCatalog(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @NonNull
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @NonNull
    public Book findById(@NonNull BookId bookId){
        Objects.requireNonNull(bookId, "book id must not be null");
        return bookRepository.findById(bookId).orElseThrow(RuntimeException::new);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onBookReturnedEvent(BookReturnedEvent bookReturnedEvent){
        Book book = bookRepository.findById(bookReturnedEvent.getBookId()).orElseThrow(RuntimeException::new);
        book.incrementQuantity();
        bookRepository.save(book);
    }

    //slusa vo ramkite na istata transakcija kaj so e publikuvan ovoj event
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onReservationCreated(ReservationCreatedEvent reservationCreatedEvent){
        Book book = bookRepository.findById(reservationCreatedEvent.getBookId()).orElseThrow(RuntimeException::new);
        book.decrementQuantity();
        bookRepository.save(book);
    }
}
