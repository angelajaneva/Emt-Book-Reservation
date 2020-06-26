package mk.ukim.finki.emt.reservation.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationId extends DomainObjectId {

    private String id;

    public ReservationId(String id) {
        super(id);
        this.id = id;
    }
}
