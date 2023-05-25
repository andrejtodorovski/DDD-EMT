package mk.ukim.finki.emt.review.services;

import mk.ukim.finki.emt.review.domain.models.User;
import mk.ukim.finki.emt.review.domain.models.UserId;
import mk.ukim.finki.emt.review.services.forms.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserId> addUser(UserForm UserForm);
    List<User> findAll();
    Optional<User> findById(UserId id);
}
