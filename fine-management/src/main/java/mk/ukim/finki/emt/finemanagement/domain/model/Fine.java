package mk.ukim.finki.emt.finemanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;

@Entity
@Table(name = "fine")
@Getter
@NoArgsConstructor
public class Fine extends AbstractEntity<FineId> {

//    @EmbeddedId
//    private FineId id;

    @Embedded
    @Column(name = "price", nullable = false)
    private Price price;

    @Embedded
    @Column(name = "description")
    private FineDescription fineDescription;

    boolean paid;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="user_id",nullable = false))
    private UserId userId;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="reservation_id",nullable = false))
    private ReservationId reservationId;

    public Fine(Price price, FineDescription fineDescription, boolean paid, UserId userId, ReservationId reservationId) {
        super(DomainObjectId.randomId(FineId.class));
        this.price = price;
        this.fineDescription = fineDescription;
        this.paid = paid;
        this.userId = userId;
        this.reservationId = reservationId;
    }
}
