package mk.ukim.finki.emt.reservation.application.form;

import com.sun.istack.NotNull;
import mk.ukim.finki.emt.reservation.domain.model.Book;

import java.io.Serializable;

public class BookItemForm implements Serializable {

    @NotNull
    private Book book;

    private static final int quantity = 1;

    public Book getBook(){
        return book;
    }

    public void setBook(Book book){
        this.book = book;
    }

    public int getQuantity(){
        return quantity;
    }

}
