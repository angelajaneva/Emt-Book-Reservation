package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

//@MappedSuperclass
@Embeddable
@Getter
public class ExpiringDate implements ValueObject {

    private Date expiringDate;

    public  ExpiringDate(){
        expiringDate = new Date();
    }

    public ExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }
    public static ExpiringDate valueOf(Date date){
        if (date == null){
            throw new IllegalArgumentException("Subscription date is required");
        }

        return new ExpiringDate(date);
    }

    @Override
    public String toString() {
        return "Subscription date: "+ expiringDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var birthDate = (ExpiringDate) o;
        return Objects.equals(expiringDate, birthDate.expiringDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiringDate);
    }

}