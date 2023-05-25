package mk.ukim.finki.emt.recipe.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.recipe.domain.models.Category;
import mk.ukim.finki.emt.recipe.domain.valueObjects.Instruction;


@Data
public class RecipeForm {

    private String recipeName;

    private String description;

    private int preparationTime;

    private int servings;

    private String ingredients;

    private Instruction instructions;
    private Category category;

}
