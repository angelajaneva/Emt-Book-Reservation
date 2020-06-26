package mk.ukim.finki.emt.bookcatalog.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;


import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
public class Book extends AbstractEntity<BookId> {

    @EmbeddedId
    private BookId id;

    @Embedded
    @Column(name = "book_name", nullable = false)
    private BookName bookName;


    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Embedded
    @Column(name = "author", nullable = false)
    private Author author;

    @Embedded
    @Column(name = "description", nullable = false)
    private Description description;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;

    public Book(@NonNull BookName bookName, @NonNull int quantity,
                @NonNull Author author, @NonNull Description description, @NonNull Genre genre) {
        super(DomainObjectId.randomId(BookId.class));
        this.bookName = bookName;
        this.quantity = quantity;
        this.author = author;
        this.description = description;
        this.genre = genre;
    }
}
