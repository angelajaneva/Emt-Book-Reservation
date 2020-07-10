package mk.ukim.finki.emt.usersubscription.domain.model.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {

    private UserId() {
        super(DomainObjectId.randomId(BookId.class).toString());
    }

    @JsonCreator
    public UserId(String id) {
        super(id);
    }
}
