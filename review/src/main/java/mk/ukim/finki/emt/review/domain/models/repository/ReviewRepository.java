package mk.ukim.finki.emt.review.domain.models.repository;

import mk.ukim.finki.emt.review.domain.models.Review;
import mk.ukim.finki.emt.review.domain.models.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
}
