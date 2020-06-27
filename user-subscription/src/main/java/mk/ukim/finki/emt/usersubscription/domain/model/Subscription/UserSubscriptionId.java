package mk.ukim.finki.emt.usersubscription.domain.model.Subscription;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class UserSubscriptionId extends DomainObjectId {

    private String id;

    public UserSubscriptionId(String id){
        super(id);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSubscriptionId)) return false;
        UserSubscriptionId that = (UserSubscriptionId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
