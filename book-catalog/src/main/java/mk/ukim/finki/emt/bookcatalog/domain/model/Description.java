package mk.ukim.finki.emt.bookcatalog.domain.model;

import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class Description implements ValueObject {

    @Column(name = "book_description")
    private String description;

    public Description(@NonNull String description) {
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return description;
    }
}

