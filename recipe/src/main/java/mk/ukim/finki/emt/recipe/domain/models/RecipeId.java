package mk.ukim.finki.emt.recipe.domain.models;


import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RecipeId extends DomainObjectId {
    private RecipeId() {
        super(RecipeId.randomId(RecipeId.class).getId());
    }

    public RecipeId( String uuid) {
        super(uuid);
    }
}
