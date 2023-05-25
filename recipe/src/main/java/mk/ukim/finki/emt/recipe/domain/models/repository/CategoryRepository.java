package mk.ukim.finki.emt.recipe.domain.models.repository;

import mk.ukim.finki.emt.recipe.domain.models.Category;
import mk.ukim.finki.emt.recipe.domain.models.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, CategoryId> {
}
