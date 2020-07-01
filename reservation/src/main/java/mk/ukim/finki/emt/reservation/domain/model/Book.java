package mk.ukim.finki.emt.reservation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Money;

@Getter
public class Book {

    private BookId id;

    private String bookName;

    private Money price;

    private int quantity;

}
