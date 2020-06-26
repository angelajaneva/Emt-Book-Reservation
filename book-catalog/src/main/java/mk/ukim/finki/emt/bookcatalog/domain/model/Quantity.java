package mk.ukim.finki.emt.bookcatalog.domain.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class Quantity implements ValueObject {

    private final int quantity;

    public Quantity(@NotNull int quantity){
        this.quantity = quantity;
    }

    public Quantity(){
        quantity = 0;
    }

    public static Quantity valueOf(int quantity){
        if (quantity < 0){
            throw new IllegalArgumentException("Quantity must be positive number");
        }

        return new Quantity(quantity);
    }

    public Quantity add(int quantity){
        if (quantity < 0){
            throw new IllegalArgumentException("Quantity must be positive number");
        }

        return new Quantity(this.quantity + quantity);
    }

    public Quantity subtract(int quantity){
        if (quantity < 0 && this.quantity - quantity < 0){
            throw new IllegalArgumentException("Quantity must be positive number");
        }

        return new Quantity(this.quantity - quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return "Quantity " + quantity;
    }
}
