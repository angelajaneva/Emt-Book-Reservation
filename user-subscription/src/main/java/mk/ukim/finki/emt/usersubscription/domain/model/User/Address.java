package mk.ukim.finki.emt.usersubscription.domain.model.User;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class Address implements ValueObject {

    private final String address;
    private final String city;

    public Address() {
        address = null;
        city = null;
    }

    public Address(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public static Address valueOf(String address, String city){
        if (address == null || city == null){
            throw new IllegalArgumentException("Address is required");
        }

        return new Address(address,city);
    }

    @Override
    public String toString() {
        return "Address:" + address + ' ' + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(address, address1.address) &&
                Objects.equals(city, address1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city);
    }
}
