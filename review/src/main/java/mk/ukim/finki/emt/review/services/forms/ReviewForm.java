package mk.ukim.finki.emt.review.services.forms;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.emt.review.domain.models.User;
import mk.ukim.finki.emt.review.domain.models.UserId;
import mk.ukim.finki.emt.review.domain.valueObjects.RecipeId;

import java.time.Instant;

@Data
public class ReviewForm {
    String reviewText;
    int rating;
    RecipeId recipeId;
    UserId userId;
}
