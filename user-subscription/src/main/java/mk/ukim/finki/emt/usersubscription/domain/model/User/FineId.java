package mk.ukim.finki.emt.usersubscription.domain.model.User;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class FineId extends DomainObjectId {

    private String id;

    private FineId(){
        super(DomainObjectId.randomId(FineId.class).toString());
    }

    @JsonCreator
    public FineId(String id) {
        super(id);
        this.id = id;
    }
}