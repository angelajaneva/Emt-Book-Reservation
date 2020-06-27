package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

//@MappedSuperclass
@Embeddable
@Getter
public class SubscriptionDate implements ValueObject {

    private final Date date;

    public SubscriptionDate(Date date) {
        this.date = date;
    }

    public SubscriptionDate(){
        date = null;
    }

    public static SubscriptionDate valueOf(Date date){
        if (date == null){
            throw new IllegalArgumentException("Subscription date is required");
        }

        return new SubscriptionDate(date);
    }

    @Override
    public String toString() {
        return "Subscription date"+ date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var birthDate = (SubscriptionDate) o;
        return Objects.equals(date, birthDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
