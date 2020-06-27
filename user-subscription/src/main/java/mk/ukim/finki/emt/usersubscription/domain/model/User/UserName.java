package mk.ukim.finki.emt.usersubscription.domain.model.User;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.identity.Name;

import javax.persistence.Embeddable;

@Embeddable
public class UserName extends Name {

    public UserName() {
    }

    public UserName(@NonNull String firstName, @NonNull String lastName) {
        super(firstName, lastName);
    }
}
