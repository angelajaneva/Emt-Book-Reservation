package mk.ukim.finki.emt.reservation.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
@Getter
@NoArgsConstructor
public class Reservation extends AbstractEntity<ReservationId> {

    @EmbeddedId
    @Column(name = "reservation_id")
    private ReservationId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="book_id",nullable = false))
    private BookId bookId;

    @Embedded
    @Column(name = "date_expiring", nullable = false)
    private DateExpiring dateExpiringReservation;

    @Embedded
    @Column(name = "date_taking", nullable = false)
    private DateTaking dateTakingReservation;

    public Reservation(@NonNull ReservationStatus status, @NonNull BookId bookId,
                       @NonNull DateExpiring dateExpiringReservation, @NonNull DateTaking dateTakingReservation) {
        super(DomainObjectId.randomId(ReservationId.class));
        this.status = status;
        this.bookId = bookId;
        this.dateExpiringReservation = dateExpiringReservation;
        this.dateTakingReservation = dateTakingReservation;
    }
}
