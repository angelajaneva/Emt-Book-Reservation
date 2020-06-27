package mk.ukim.finki.emt.usersubscription.domain.repository;

import mk.ukim.finki.emt.usersubscription.domain.model.User.User;
import mk.ukim.finki.emt.usersubscription.domain.model.User.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}
