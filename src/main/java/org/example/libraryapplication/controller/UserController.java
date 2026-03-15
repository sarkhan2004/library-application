package org.example.libraryapplication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.comment.CommentRequestDto;
import org.example.libraryapplication.dto.comment.CommentResponseDto;
import org.example.libraryapplication.dto.user.UserResponseDto;
import org.example.libraryapplication.dto.user.UserRequestDto;
import org.example.libraryapplication.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto requestBody) {
        return userService.createUser(requestBody);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto requestBody) {
        return userService.updateUser(id, requestBody);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    

}
