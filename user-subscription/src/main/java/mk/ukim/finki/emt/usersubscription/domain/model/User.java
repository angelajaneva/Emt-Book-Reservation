package mk.ukim.finki.emt.usersubscription.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private UserId id;

    //vo slucaj ako mu se pise kazna a toj saka vo toj moment kniga da rezervira
    @Version
    private Long version;

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
}
