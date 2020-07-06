package mk.ukim.finki.emt.bookcatalog;

import mk.ukim.finki.emt.bookcatalog.domain.model.*;
import mk.ukim.finki.emt.bookcatalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Money;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
public class DataGenerator implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataGenerator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    @PostConstruct
//    @Transactional
    public void generateData(){
        if (bookRepository.findAll().size()==0) {
            var books = new ArrayList<Book>();
            books.add(createBook(new BookId("1"), new BookName("Flashlight L"), new Author("Kiril", "Ristov"), new Description("Test"), Genre.Drama, new Money(5642), 10));
            books.add(createBook(new BookId("2"), new BookName("Flashlight M"), new Author("Kiril", "Ristov"), new Description("Test"), Genre.Classic,new Money(4029), 10));
            books.add(createBook(new BookId("3"), new BookName("Flashlight S"), new Author("Kiril", "Ristov"), new Description("Test"), Genre.Mystery,new Money(2416), 10));
            bookRepository.saveAll(books);
        }

    }

    private Book createBook(BookId id, BookName bookName, Author author, Description description, Genre genre, Money price, int quantity){
        return new Book(bookName, quantity, author, description, genre, price.getAmount());
    }

    @Override
    public void run(String... args) throws Exception {
        generateData();
    }
}
