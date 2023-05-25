package mk.ukim.finki.emt.review.services;

import mk.ukim.finki.emt.review.domain.models.Review;
import mk.ukim.finki.emt.review.domain.models.ReviewId;
import mk.ukim.finki.emt.review.services.forms.ReviewForm;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<ReviewId> addReview(ReviewForm ReviewForm);
    List<Review> findAll();
    Optional<Review> findById(ReviewId id);
}
