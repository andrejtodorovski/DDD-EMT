package mk.ukim.finki.emt.recipe.domain.models;

import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class CategoryId extends DomainObjectId {
    private CategoryId() {
        super(CategoryId.randomId(CategoryId.class).getId());
    }

    public CategoryId(String uuid) {
        super(uuid);
    }
}
