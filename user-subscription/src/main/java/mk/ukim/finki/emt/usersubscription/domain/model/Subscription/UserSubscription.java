package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.usersubscription.domain.model.User.User;
import mk.ukim.finki.emt.usersubscription.domain.model.User.UserId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_subscription")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSubscription extends AbstractEntity<UserSubscriptionId> {

    @Id
    @Column(name = "id")
    private UserSubscriptionId id;

    @ManyToOne
    @JsonManagedReference
    private User userId;

    @ManyToOne
    @JsonManagedReference
    private Subscription subscriptionId;

    private SubscriptionDate subscriptionDate;

    private ExpiringDate expiringDate;

    private ExpiringStatus status;

    public UserSubscription(@NonNull User user, @NonNull Subscription subscription, @NonNull Date subscriptionDate, @NonNull Date expiringDate, ExpiringStatus status){
        super(DomainObjectId.randomId(UserSubscriptionId.class));
        this.userId = user;
        this.subscriptionId = subscription;
        this.subscriptionDate = SubscriptionDate.valueOf(subscriptionDate);
        this.expiringDate = ExpiringDate.valueOf(expiringDate);
        this.status = status;
    }

}
