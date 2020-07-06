package mk.ukim.finki.emt.finemanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationId extends DomainObjectId {

    private String id;

    private ReservationId(){
        super(DomainObjectId.randomId(ReservationId.class).toString());
    }

    @JsonCreator
    public ReservationId(String id) {
        super(id);
        this.id = id;
    }
}
