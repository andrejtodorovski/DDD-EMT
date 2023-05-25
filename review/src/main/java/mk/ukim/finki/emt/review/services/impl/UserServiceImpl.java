package mk.ukim.finki.emt.review.services.impl;

import mk.ukim.finki.emt.review.domain.models.User;
import mk.ukim.finki.emt.review.domain.models.UserId;
import mk.ukim.finki.emt.review.domain.models.repository.UserRepository;
import mk.ukim.finki.emt.review.services.UserService;
import mk.ukim.finki.emt.review.services.forms.UserForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserId> addUser(UserForm UserForm) {
        return Optional.ofNullable(userRepository.saveAndFlush(toDomainObject(UserForm)).getId());
    }

    private User toDomainObject(UserForm userForm) {
        return new User(
                userForm.getUsername(),
                userForm.getPassword(),
                userForm.getName(),
                userForm.getSurname());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UserId id) {
        return userRepository.findById(id);
    }
}
