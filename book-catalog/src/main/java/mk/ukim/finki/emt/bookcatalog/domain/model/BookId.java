package mk.ukim.finki.emt.bookcatalog.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BookId extends DomainObjectId {

    private String id;

    public BookId(String id) {
        super(id);
    }
}
