package mk.ukim.finki.emt.review.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.review.domain.valueObjects.RecipeId;

import java.time.Instant;

@Entity
@Table(name = "reviews")
@Getter
public class Review extends AbstractEntity<ReviewId> {
    private String reviewText;
    private int rating;
    private Instant addedOn;
    @AttributeOverride(name = "id", column = @Column(name = "recipe_id", nullable = false))
    private RecipeId recipeId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Review(String reviewText, int rating, RecipeId recipeId, User user) {
        super(ReviewId.randomId(ReviewId.class));
        this.reviewText = reviewText;
        this.rating = rating;
        this.addedOn = Instant.now();
        this.recipeId = recipeId;
        this.user = user;
    }

    public Review() {
        super(ReviewId.randomId(ReviewId.class));
    }
}
