package mk.ukim.finki.emt.usersubscription.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class BirthDate implements ValueObject {

    private final Date date;

    public BirthDate(Date date) {
        this.date = date;
    }

    public BirthDate(){
        date = null;
    }

    public static BirthDate valueOf(Date date){
        if (date == null || date.after(new Date())){
            throw new IllegalArgumentException("Birth date is required");
        }

        return new BirthDate(date);
    }

    @Override
    public String toString() {
        return "Birth date"+ date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthDate birthDate = (BirthDate) o;
        return Objects.equals(date, birthDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
