package mk.ukim.finki.emt.reservation.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.NonNull;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
public class DateExpiring implements ValueObject {

    private LocalDate dateExpiring;
    private boolean expired;

    public DateExpiring(){
        dateExpiring = LocalDate.now();
    }

    public DateExpiring(@NonNull LocalDate dateExpiring) {
//        //datata sto e now() plus 3 dena
//        this.dateExpiring = date.plusDays(3L);
        this.dateExpiring = dateExpiring;
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

    public boolean checkExpired() {
        setExpired();
        //treba before za test e after
        return dateExpiring.isAfter(LocalDate.now());
    }
}
