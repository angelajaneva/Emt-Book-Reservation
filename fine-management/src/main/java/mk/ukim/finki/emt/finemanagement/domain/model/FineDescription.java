package mk.ukim.finki.emt.finemanagement.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FineDescription implements ValueObject {

    private String description;

    public FineDescription(@NonNull String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FineDescription)) return false;
        FineDescription that = (FineDescription) o;
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
