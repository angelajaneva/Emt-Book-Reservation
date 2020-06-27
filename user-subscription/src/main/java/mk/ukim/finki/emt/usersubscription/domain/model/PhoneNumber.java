package mk.ukim.finki.emt.usersubscription.domain.model;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class PhoneNumber implements ValueObject {

    private final String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public PhoneNumber(){
        number = null;
    }

    public static PhoneNumber valueOf(String number){
        if (number == null){
            throw new IllegalArgumentException("Phone number is required");
        }

        return new PhoneNumber(number);
    }

    @Override
    public String toString() {
        return "Phone Number: "+ number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
