package mk.ukim.finki.emt.finemanagement.domain.repository;

import mk.ukim.finki.emt.finemanagement.domain.model.Fine;
import mk.ukim.finki.emt.finemanagement.domain.model.FineId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, FineId> {
}
