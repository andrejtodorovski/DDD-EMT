package mk.ukim.finki.emt.review.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.review.domain.models.User;
import mk.ukim.finki.emt.review.domain.models.UserId;
import mk.ukim.finki.emt.review.services.UserService;
import mk.ukim.finki.emt.review.services.forms.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UserId id) {
        return userService.findById(id)
                .map(User -> ResponseEntity.ok().body(User))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/add")
    public ResponseEntity<UserId> addUser(@RequestBody UserForm User) {
        return userService.addUser(User)
                .map(UserId -> ResponseEntity.ok().body(UserId))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
