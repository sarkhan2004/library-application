package org.example.libraryapplication.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.user.ResponseBody;
import org.example.libraryapplication.entity.User;
import org.example.libraryapplication.repository.UserRepository;
import org.example.libraryapplication.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Data

public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseBody createUser(@RequestBody User requestBody) {
        userService.createUser(requestBody);
        return null;
    }

    @GetMapping("{id}")
    public ResponseBody getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

}
