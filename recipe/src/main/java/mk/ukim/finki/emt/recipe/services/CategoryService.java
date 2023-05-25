package mk.ukim.finki.emt.recipe.services;

import mk.ukim.finki.emt.recipe.domain.models.Category;
import mk.ukim.finki.emt.recipe.domain.models.CategoryId;
import mk.ukim.finki.emt.recipe.services.forms.CategoryForm;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<CategoryId> addCategory(CategoryForm categoryForm);
    List<Category> findAll();
    Optional<Category> findById(CategoryId id);
}
