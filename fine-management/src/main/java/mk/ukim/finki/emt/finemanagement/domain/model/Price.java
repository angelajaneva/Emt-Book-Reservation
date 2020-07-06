package mk.ukim.finki.emt.finemanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Embeddable;

@Embeddable
public class Price extends Money {

    public Price(@NonNull int amount) {
        super(amount);
    }

    public Price() {
    }
}
