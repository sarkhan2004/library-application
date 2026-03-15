package org.example.libraryapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.comment.CommentRequestDto;
import org.example.libraryapplication.dto.comment.CommentResponseDto;
import org.example.libraryapplication.dto.user.UserRequestDto;
import org.example.libraryapplication.dto.user.UserResponseDto;
import org.example.libraryapplication.entity.Comment;
import org.example.libraryapplication.entity.User;
import org.example.libraryapplication.exceptions.UserNotFoundException;
import org.example.libraryapplication.mapper.CommentMapper;
import org.example.libraryapplication.mapper.UserMapper;
import org.example.libraryapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;
    private final BookService bookService;

    public UserResponseDto createUser(UserRequestDto request) {
        User user = userMapper.toEntity(request);
        user.setCreatedAt(LocalDateTime.now());
        user.setModifiedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserResponseDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        return userMapper.toDto(user);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto updateUser(Long id, UserRequestDto request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setBirthday(request.getBirthday());
        user.setBalance(request.getBalance());
        user.setRole(request.getRole());
        user.setModifiedAt(LocalDateTime.now());

        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(request.getPassword());
        }

        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }



}
