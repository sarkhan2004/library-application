package org.example.libraryapplication.controller;

import lombok.Data;
import org.example.libraryapplication.dto.user.ResponseBody;
import org.example.libraryapplication.entity.UserEntity;
import org.example.libraryapplication.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Data
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseBody createUser(@RequestBody RequestBody requestBody) {
        UserEntity user = new UserEntity();

        return null;
    }
}
