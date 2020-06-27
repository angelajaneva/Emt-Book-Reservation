package mk.ukim.finki.emt.usersubscription.domain.model;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class Email implements ValueObject {

    private final String email;

    public Email(String email) {
        this.email = email;
    }

    public Email (){
        email = null;
    }

    public static Email valueOf(String email){
        if (email == null) {
            throw new IllegalArgumentException("Email is required");
        }

        return new Email(email);
    }

    @Override
    public String toString() {
        return "Email: " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
