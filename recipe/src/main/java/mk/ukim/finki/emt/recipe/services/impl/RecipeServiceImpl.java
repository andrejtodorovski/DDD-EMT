package mk.ukim.finki.emt.recipe.services.impl;

import mk.ukim.finki.emt.recipe.domain.models.Recipe;
import mk.ukim.finki.emt.recipe.domain.models.RecipeId;
import mk.ukim.finki.emt.recipe.domain.models.repository.RecipeRepository;
import mk.ukim.finki.emt.recipe.services.RecipeService;
import mk.ukim.finki.emt.recipe.services.forms.RecipeForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Optional<RecipeId> addRecipe(RecipeForm recipeForm) {
        return Optional.ofNullable(recipeRepository.saveAndFlush(toDomainObject(recipeForm)).getId());
    }

    private Recipe toDomainObject(RecipeForm recipeForm) {
        return new Recipe(recipeForm.getRecipeName(),
                recipeForm.getDescription(),
                recipeForm.getPreparationTime(),
                recipeForm.getServings(),
                recipeForm.getIngredients(),
                recipeForm.getInstructions(),
                recipeForm.getCategory());
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(RecipeId id) {
        return recipeRepository.findById(id);
    }
}
