package mk.ukim.finki.emt.review.domain.models;

import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;


public class ReviewId extends DomainObjectId {
    private ReviewId() {
        super(ReviewId.randomId(ReviewId.class).getId());
    }

    public ReviewId(String uuid) {
        super(uuid);
    }
}
