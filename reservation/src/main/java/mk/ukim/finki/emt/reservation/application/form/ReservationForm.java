package mk.ukim.finki.emt.reservation.application.form;

import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emt.reservation.application.BookCatalog;
import mk.ukim.finki.emt.reservation.domain.model.BookId;
import mk.ukim.finki.emt.reservation.domain.model.DateTaking;
import mk.ukim.finki.emt.reservation.domain.model.UserId;

@Getter
@Setter
public class ReservationForm {

    @NonNull
    private BookId bookId;

    @NonNull
    private UserId userId;

    @NonNull
    private DateTaking dateTakingReservation;

    public ReservationForm (@NonNull BookId bookId, @NonNull UserId userId, @NonNull DateTaking dateTakingReservation){
        this.bookId = bookId;
        this.userId = userId;
        this.dateTakingReservation = dateTakingReservation;
    }

}
