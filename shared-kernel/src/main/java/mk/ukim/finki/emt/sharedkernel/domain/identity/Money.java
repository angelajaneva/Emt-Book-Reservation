package mk.ukim.finki.emt.sharedkernel.domain.identity;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@Embeddable
@Getter
public class Money implements ValueObject {

    private final int amount;

    public Money(@NonNull int amount){
        this.amount = amount;
    }
    public Money (){
        amount = 0;
    }

   public static Money valueOf(int amount){
        if (amount < 0){
            //exception treba da se naprave
            throw new IllegalArgumentException("Money cannot have a negative value");
        }

        return new Money(amount);
   }

   public Money addMoney(int amount){
       if (amount < 0){
           //exception treba da se naprave
           throw new IllegalArgumentException("Money cannot have a negative value");
       }

       return new Money(this.amount + amount);
   }

    public Money subtractMoney(int amount){
        if (amount < 0){
            //exception treba da se naprave
            throw new IllegalArgumentException("Money cannot have a negative value");
        }

        return new Money(this.amount - amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money: " + amount;
    }
}
