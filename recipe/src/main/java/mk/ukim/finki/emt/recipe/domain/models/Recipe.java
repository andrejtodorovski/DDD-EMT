package mk.ukim.finki.emt.recipe.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.recipe.domain.valueObjects.Instruction;

@Entity
@Table(name = "recipes")
@Getter
public class Recipe extends AbstractEntity<RecipeId> {

        private String recipeName;

        private String description;

        private int preparationTime;

        private int servings;

        private String ingredients;

        private Instruction instructions;

        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

        public Recipe(String recipeName, String description, int preparationTime, int servings, String ingredients, Instruction instructions, Category category) {
                super(RecipeId.randomId(RecipeId.class));
                this.recipeName = recipeName;
                this.description = description;
                this.preparationTime = preparationTime;
                this.servings = servings;
                this.ingredients = ingredients;
                this.instructions = instructions;
                this.category = category;
        }

        public Recipe() {
                super(RecipeId.randomId(RecipeId.class));
        }
}
