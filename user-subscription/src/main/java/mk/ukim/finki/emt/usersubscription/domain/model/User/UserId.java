package mk.ukim.finki.emt.usersubscription.domain.model.User;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {

    private String id;

    public UserId(String id) {
        super(id);
        this.id = id;
    }
}
