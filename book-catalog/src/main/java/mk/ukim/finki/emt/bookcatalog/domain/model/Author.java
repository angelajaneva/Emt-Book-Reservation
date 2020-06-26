package mk.ukim.finki.emt.bookcatalog.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.identity.Name;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class Author extends Name {

    public Author() {
    }

    public Author(@NonNull String firstName, @NonNull String lastName) {
        super(firstName, lastName);
    }
}
