package mk.ukim.finki.emt.review.domain.valueObjects;

import jakarta.persistence.Embeddable;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class RecipeId extends DomainObjectId {
    public RecipeId(String uuid) {
        super(uuid);
    }

    public RecipeId() {

    }
}
