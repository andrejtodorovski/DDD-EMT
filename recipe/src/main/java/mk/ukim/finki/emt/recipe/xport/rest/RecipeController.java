package mk.ukim.finki.emt.recipe.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.recipe.domain.models.Recipe;
import mk.ukim.finki.emt.recipe.domain.models.RecipeId;
import mk.ukim.finki.emt.recipe.services.RecipeService;
import mk.ukim.finki.emt.recipe.services.forms.RecipeForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    @GetMapping
    public ResponseEntity<List<Recipe>> findAll() {
        return ResponseEntity.ok(recipeService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable RecipeId id) {
        return recipeService.findById(id)
                .map(recipe -> ResponseEntity.ok().body(recipe))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<RecipeId> addRecipe(@RequestBody RecipeForm recipe) {
        return recipeService.addRecipe(recipe)
                .map(recipeId -> ResponseEntity.ok().body(recipeId))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
