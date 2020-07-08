package mk.ukim.finki.emt.usersubscription.application;

import mk.ukim.finki.emt.usersubscription.domain.model.User.User;
import mk.ukim.finki.emt.usersubscription.domain.model.User.UserId;
import mk.ukim.finki.emt.usersubscription.domain.model.User.UserStatus;
import mk.ukim.finki.emt.usersubscription.domain.repository.UserRepository;
import mk.ukim.finki.emt.usersubscription.integration.FineCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class UserCatalog {

    private final UserRepository userRepository;

    public UserCatalog(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById (UserId id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public User onBookReturnedEvent(FineCreatedEvent fineCreatedEvent) throws Exception {
        var user = userRepository.findById(fineCreatedEvent.getUserId()).orElseThrow(RuntimeException::new);
        if (user == null){
            throw new Exception("User not found");
        }
        user.setStatus(UserStatus.Fined);
        userRepository.save(user);

        return user;
    }


}
