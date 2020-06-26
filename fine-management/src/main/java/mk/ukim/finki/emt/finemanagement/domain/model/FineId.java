package mk.ukim.finki.emt.finemanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class FineId extends DomainObjectId {

    private String id;

    public FineId(String id) {
        super(id);
        this.id = id;
    }
}
