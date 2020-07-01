package mk.ukim.finki.emt.usersubscription.domain.model.User;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.usersubscription.domain.model.Subscription.UserSubscription;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity<UserId> {

//    @EmbeddedId
//    @Column(name = "user_id")
//    private UserId id;

    //vo slucaj ako mu se pise kazna a toj saka vo toj moment kniga da rezervira
    @Version
    private Long version = 0L;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "first_name", column =
            @Column(name = "user_first_name")),
            @AttributeOverride(name = "last_name",
                    column = @Column(name = "user_last_name"))
    })
    private UserName fullName;

    @Embedded
    @Column(name = "email", nullable = false)
    private Email email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "number", column =
            @Column(name = "phone_number"))
    })    private PhoneNumber phoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column =
            @Column(name = "birth_date"))
    })
    private BirthDate birthDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column =
            @Column(name = "home_address")),
            @AttributeOverride(name = "city",
                    column = @Column(name = "home_city"))
    })
    private Address address;

    @OneToMany(mappedBy = "subscriptionId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserSubscription> subscriptions = new ArrayList<>();

    public User(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phoneNumber, @NonNull Date birthDate, @NonNull String address, @NonNull String city) {
        super(DomainObjectId.randomId(UserId.class));
        this.fullName = new UserName(firstName, lastName);
        this.email = Email.valueOf(email);
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
        this.birthDate = BirthDate.valueOf(birthDate);
        this.address = Address.valueOf(address, city);
    }

    public User(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phoneNumber, @NonNull Date birthDate, @NonNull String address, @NonNull String city, List<UserSubscription> subscriptions) {
        super(DomainObjectId.randomId(UserId.class));
        this.fullName = new UserName(firstName, lastName);
        this.email = Email.valueOf(email);
        this.phoneNumber = PhoneNumber.valueOf(phoneNumber);
        this.birthDate = BirthDate.valueOf(birthDate);
        this.address = Address.valueOf(address, city);
        this.subscriptions = subscriptions == null? new ArrayList<>(): subscriptions;
    }
}
