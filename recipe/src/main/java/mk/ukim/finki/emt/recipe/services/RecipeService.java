package mk.ukim.finki.emt.recipe.services;

import mk.ukim.finki.emt.recipe.domain.models.Recipe;
import mk.ukim.finki.emt.recipe.domain.models.RecipeId;
import mk.ukim.finki.emt.recipe.services.forms.RecipeForm;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Optional<RecipeId> addRecipe(RecipeForm recipeForm);
    List<Recipe> findAll();
    Optional<Recipe> findById(RecipeId id);
}
