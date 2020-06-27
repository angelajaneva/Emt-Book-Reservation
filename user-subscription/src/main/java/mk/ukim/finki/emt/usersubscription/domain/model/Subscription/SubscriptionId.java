package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class SubscriptionId extends DomainObjectId {

    private String id;

    public SubscriptionId(String id){
        super(id);
        this.id = id;
    }

}
