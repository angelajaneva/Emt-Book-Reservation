package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserSubscriptionId extends DomainObjectId {

    private String id;

    public UserSubscriptionId(String id){
        super(id);
        this.id = id;
    }
}
