package mk.ukim.finki.emt.reservation.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BookId extends DomainObjectId {

    public BookId(String id) {
        super(id);
    }
}
