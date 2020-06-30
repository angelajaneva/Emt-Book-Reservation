package mk.ukim.finki.emt.reservation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Money;

@Getter
@AllArgsConstructor
public class Book {

    private BookId bookId;

    private String bookName;

    private Money price;

    private int quantity;

}
