package mk.ukim.finki.emt.recipe.domain.models.repository;

import mk.ukim.finki.emt.recipe.domain.models.Recipe;
import mk.ukim.finki.emt.recipe.domain.models.RecipeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, RecipeId>{
}
