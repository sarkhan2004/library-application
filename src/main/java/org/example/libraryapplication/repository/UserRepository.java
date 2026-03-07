package org.example.libraryapplication.repository;

import org.example.libraryapplication.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class UserRepository {

    private List<UserEntity> users = new ArrayList<>();
    private Long id = 1L;

    public List<UserEntity> findAll() {
        return users;
    }

    public UserEntity save(UserEntity user) {
        user.setId(id);
        id++;
        users.add(user);
        return user;
    }

    public Optional<UserEntity> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
