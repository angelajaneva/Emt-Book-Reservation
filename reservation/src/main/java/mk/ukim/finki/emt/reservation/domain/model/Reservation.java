package mk.ukim.finki.emt.reservation.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
@Getter
@NoArgsConstructor
@Where(clause = "deleted=false")
public class Reservation extends AbstractEntity<ReservationId> {

//    @EmbeddedId
//    @Column(name = "reservation_id")
//    private ReservationId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;

    @Column(name = "deleted")
    private boolean deleted = false;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="book_id",nullable = false))
    private BookId bookId;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="user_id",nullable = false))
    private UserId userId;

    @Embedded
    @Column(name = "date_expiring", nullable = false)
    private DateExpiring dateExpiringReservation;

    @Embedded
    @Column(name = "date_taking", nullable = false)
    private DateTaking dateTakingReservation;

    public Reservation(@NonNull ReservationStatus status, @NonNull BookId bookId, @NonNull UserId userId,
                       @NonNull DateExpiring dateExpiringReservation, @NonNull DateTaking dateTakingReservation) {
        super(DomainObjectId.randomId(ReservationId.class));
        this.status = status;
        this.bookId = bookId;
        this.userId = userId;
        this.dateExpiringReservation = dateExpiringReservation;
        this.dateTakingReservation = dateTakingReservation;
    }

    public void changeReservationStatus(@NonNull ReservationStatus reservationStatus){
        this.status = reservationStatus;
    }

    public void delete(){
        this.deleted = true;
    }
}
