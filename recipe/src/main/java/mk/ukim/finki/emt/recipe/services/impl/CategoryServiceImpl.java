package mk.ukim.finki.emt.recipe.services.impl;

import mk.ukim.finki.emt.recipe.domain.models.Category;
import mk.ukim.finki.emt.recipe.domain.models.CategoryId;
import mk.ukim.finki.emt.recipe.domain.models.repository.CategoryRepository;
import mk.ukim.finki.emt.recipe.services.CategoryService;
import mk.ukim.finki.emt.recipe.services.forms.CategoryForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<CategoryId> addCategory(CategoryForm categoryForm) {
        return Optional.ofNullable(categoryRepository.saveAndFlush(toDomainObject(categoryForm)).getId());
    }

    private Category toDomainObject(CategoryForm categoryForm) {
        return new Category(categoryForm.getCategoryName());
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(CategoryId id) {
        return categoryRepository.findById(id);
    }
}
