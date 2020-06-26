package mk.ukim.finki.emt.bookcatalog.domain.repository;

import mk.ukim.finki.emt.bookcatalog.domain.model.Book;
import mk.ukim.finki.emt.bookcatalog.domain.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
}
