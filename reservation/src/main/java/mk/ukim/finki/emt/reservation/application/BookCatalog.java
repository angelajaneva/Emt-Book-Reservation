package mk.ukim.finki.emt.reservation.application;

import mk.ukim.finki.emt.reservation.domain.model.Book;
import mk.ukim.finki.emt.reservation.domain.model.BookId;

import java.util.List;

public interface BookCatalog {

    List<Book> findAll();

    Book findById(BookId productId);

}
