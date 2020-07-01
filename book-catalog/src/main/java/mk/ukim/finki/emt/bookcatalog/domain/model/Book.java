package mk.ukim.finki.emt.bookcatalog.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Money;
import org.hibernate.annotations.Where;
import org.springframework.lang.NonNull;


import javax.persistence.*;

@Entity
@Table(name = "book")
@Where(clause = "deleted=false")
@Getter
@NoArgsConstructor
public class Book extends AbstractEntity<BookId> {

//    @EmbeddedId
//    @Column(name = "book_id")
//    private BookId id;

    @Version
    private Long version = 0L;

    @Embedded
    @Column(name = "book_name", nullable = false)
    private BookName bookName;

    @Embedded
    @Column(name = "description", nullable = false)
    private Description description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column =
            @Column(name = "author_first_name")),
            @AttributeOverride(name = "lastName",
                    column = @Column(name = "author_last_name"))
    })
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column =
            @Column(name = "price"))
    })
    private Money price;

    @Embedded
    @Column(name = "quantity", nullable = false)
    private Quantity quantity;

    @Column(name = "deleted")
    private boolean deleted = false;

    public Book(@NonNull BookName bookName, @NonNull int quantity,
                @NonNull Author author, @NonNull Description description, @NonNull Genre genre, @NonNull int money) {
        super(DomainObjectId.randomId(BookId.class));
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.genre = genre;

        this.price = Money.valueOf(money);
        this.quantity = Quantity.valueOf(quantity);
    }

    public void decrementQuantity() {
       this.quantity = this.quantity.decrement();
    }

    public void incrementQuantity() {
        this.quantity = this.quantity.increment();
    }


}
