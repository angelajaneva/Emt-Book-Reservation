package mk.ukim.finki.emt.bookcatalog.domain.model;

import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class BookName implements ValueObject {


    private String bookName;

    public BookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookName)) return false;
        BookName bookName1 = (BookName) o;
        return Objects.equals(bookName, bookName1.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }

    @Override
    public String toString() {
        return bookName;
    }
}
