package mk.ukim.finki.emt.bookcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;


@Embeddable
public class BookId extends DomainObjectId {

    private BookId() {
        super(DomainObjectId.randomId(BookId.class).toString());
    }

    @JsonCreator
    public BookId(String id) {
        super(id);
    }

}
