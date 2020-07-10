package mk.ukim.finki.emt.finemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {


    private UserId() {
        super(DomainObjectId.randomId(UserId.class).toString());
    }

    @JsonCreator
    public UserId(String id) {
        super(id);
    }
}
