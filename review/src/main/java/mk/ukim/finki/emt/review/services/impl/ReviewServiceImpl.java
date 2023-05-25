package mk.ukim.finki.emt.review.services.impl;

import mk.ukim.finki.emt.review.domain.models.Review;
import mk.ukim.finki.emt.review.domain.models.ReviewId;
import mk.ukim.finki.emt.review.domain.models.repository.ReviewRepository;
import mk.ukim.finki.emt.review.domain.models.repository.UserRepository;
import mk.ukim.finki.emt.review.services.ReviewService;
import mk.ukim.finki.emt.review.services.forms.ReviewForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<ReviewId> addReview(ReviewForm ReviewForm) {
        return Optional.ofNullable(reviewRepository.saveAndFlush(toDomainObject(ReviewForm)).getId());
    }

    private Review toDomainObject(ReviewForm reviewForm) {
        return new Review(
                reviewForm.getReviewText(),
                reviewForm.getRating(),
                reviewForm.getRecipeId(),
                userRepository.findById(reviewForm.getUserId()).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findById(ReviewId id) {
        return reviewRepository.findById(id);
    }
}
