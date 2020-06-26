package mk.ukim.finki.emt.reservation.domain.repository;

import mk.ukim.finki.emt.reservation.domain.model.Reservation;
import mk.ukim.finki.emt.reservation.domain.model.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
