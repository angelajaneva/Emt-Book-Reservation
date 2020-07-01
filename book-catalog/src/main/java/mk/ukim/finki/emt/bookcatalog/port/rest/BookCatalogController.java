package mk.ukim.finki.emt.bookcatalog.port.rest;

import mk.ukim.finki.emt.bookcatalog.application.BookCatalog;
import mk.ukim.finki.emt.bookcatalog.domain.model.Book;
import mk.ukim.finki.emt.bookcatalog.domain.model.BookId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookCatalogController {

    private final BookCatalog bookCatalog;

    BookCatalogController(BookCatalog bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") String bookId) {
        return bookCatalog.findById(new BookId(bookId));
    }

    @GetMapping
    public List<Book> findAll() {
        return bookCatalog.findAll();
    }


}
