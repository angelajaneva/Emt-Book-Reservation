package mk.ukim.finki.emt.reservation.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Book {

    private BookId id;

    private String bookName;

    private Money price;

    private int quantity;

}
