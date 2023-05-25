package mk.ukim.finki.emt.review.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "users")
@Getter
public class User extends AbstractEntity<UserId> {
    String username;
    String password;
    String name;
    String surname;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public User(String username, String password, String name, String surname) {
        super(UserId.randomId(UserId.class));
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
