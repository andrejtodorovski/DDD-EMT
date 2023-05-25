package mk.ukim.finki.emt.review.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.review.domain.models.Review;
import mk.ukim.finki.emt.review.domain.models.ReviewId;
import mk.ukim.finki.emt.review.services.ReviewService;
import mk.ukim.finki.emt.review.services.forms.ReviewForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping
    public ResponseEntity<List<Review>> findAll() {
        return ResponseEntity.ok(reviewService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable ReviewId id) {
        return reviewService.findById(id)
                .map(Review -> ResponseEntity.ok().body(Review))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<ReviewId> addReview(@RequestBody ReviewForm Review) {
        return reviewService.addReview(Review)
                .map(ReviewId -> ResponseEntity.ok().body(ReviewId))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
