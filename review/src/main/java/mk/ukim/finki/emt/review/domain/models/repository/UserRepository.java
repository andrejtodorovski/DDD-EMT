package mk.ukim.finki.emt.review.domain.models.repository;

import mk.ukim.finki.emt.review.domain.models.User;
import mk.ukim.finki.emt.review.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserId> {
}
