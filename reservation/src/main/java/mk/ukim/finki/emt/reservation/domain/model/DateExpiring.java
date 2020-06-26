package mk.ukim.finki.emt.reservation.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class DateExpiring implements ValueObject {

    private LocalDate dateExpiring;
    private boolean expired;


    public DateExpiring(@NonNull LocalDate date) {
//        //datata sto e now() plus 3 dena
//        this.dateExpiring = date.plusDays(3L);
        this.dateExpiring = date;
        setExpired();
    }

    private void setExpired() {
        if (dateExpiring.isBefore(LocalDate.now()))
            this.expired = true;

        this.expired = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateExpiring)) return false;
        DateExpiring that = (DateExpiring) o;
        return expired == that.expired &&
                Objects.equals(dateExpiring, that.dateExpiring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateExpiring, expired);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dateExpiring);
        sb.append(", ");
        sb.append(expired);
        return sb.toString();

    }
}
