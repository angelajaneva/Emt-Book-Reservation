package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Money;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscription")
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class Subscription extends AbstractEntity<SubscriptionId> {

    @EmbeddedId
    @Column(name = "subscription_id")
    private SubscriptionId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type", nullable = false)
    private SubscriptionType type;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column =
            @Column(name = "subscription_price"))
    })
    private Money price;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserSubscription> users = new ArrayList<>();

    public Subscription (@NonNull SubscriptionType type, @NonNull int amount){
        super(DomainObjectId.randomId(SubscriptionId.class));
        this.type = type;
        this.price = Money.valueOf(amount);
    }

    public Subscription (@NonNull SubscriptionType type, @NonNull int amount, List<UserSubscription> users){
        super(DomainObjectId.randomId(SubscriptionId.class));
        this.type = type;
        this.price = Money.valueOf(amount);
        this.users = users == null? new ArrayList<>(): users;
    }
}
