package mk.ukim.finki.emt.recipe.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.recipe.domain.models.Category;
import mk.ukim.finki.emt.recipe.domain.models.CategoryId;
import mk.ukim.finki.emt.recipe.services.CategoryService;
import mk.ukim.finki.emt.recipe.services.forms.CategoryForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable CategoryId id) {
        return categoryService.findById(id)
                .map(Category -> ResponseEntity.ok().body(Category))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryId> addCategory(@RequestBody CategoryForm Category) {
        return categoryService.addCategory(Category)
                .map(CategoryId -> ResponseEntity.ok().body(CategoryId))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
