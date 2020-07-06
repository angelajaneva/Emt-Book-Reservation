package mk.ukim.finki.emt.reservation.application.form;

import lombok.Getter;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import mk.ukim.finki.emt.reservation.domain.model.ReservationStatus;
import org.springframework.lang.NonNull;

@Getter
public class ChangeReservationStatusForm {

    @NonNull
    private ReservationId reservationId;

    @NonNull
    private ReservationStatus status;

    public ChangeReservationStatusForm(@NonNull ReservationId reservationId, @NonNull ReservationStatus status){
        this.reservationId = reservationId;
        this.status = status;
    }
}
