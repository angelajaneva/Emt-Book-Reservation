package mk.ukim.finki.emt.reservation.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.NonNull;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
public class DateTaking implements ValueObject {

    private LocalDate dateTaking;

    public DateTaking(@NonNull LocalDate dateTaking) {
        this.dateTaking = dateTaking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateTaking)) return false;
        DateTaking that = (DateTaking) o;
        return Objects.equals(dateTaking, that.dateTaking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTaking);
    }

    @Override
    public String toString() {
        return dateTaking.toString();
    }
}
