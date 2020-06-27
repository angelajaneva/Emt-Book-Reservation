package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class ExpiringDate implements ValueObject {

    private final Date date;

    public ExpiringDate(Date date) {
        this.date = date;
    }

    public ExpiringDate(){
        date = new Date();
    }

    public static ExpiringDate valueOf(Date date){
        if (date == null){
            throw new IllegalArgumentException("Subscription date is required");
        }

        return new ExpiringDate(date);
    }

    @Override
    public String toString() {
        return "Subscription date"+ date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var birthDate = (ExpiringDate) o;
        return Objects.equals(date, birthDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
