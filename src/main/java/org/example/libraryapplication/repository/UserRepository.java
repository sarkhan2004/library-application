package org.example.libraryapplication.repository;

import org.example.libraryapplication.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();
    private Long id = 1L;

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(id);
        id++;
        users.add(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
