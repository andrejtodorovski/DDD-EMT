package mk.ukim.finki.emt.recipe.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "categories")
@Getter
public class Category extends AbstractEntity<CategoryId> {
    private String categoryName;

    public Category(String categoryName) {
        super(CategoryId.randomId(CategoryId.class));
        this.categoryName = categoryName;
    }

    public Category() {
        super(CategoryId.randomId(CategoryId.class));
    }
}
