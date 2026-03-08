package org.example.libraryapplication.mapper;

import org.example.libraryapplication.dto.user.UserRequestDto;
import org.example.libraryapplication.dto.user.UserResponseDto;
import org.example.libraryapplication.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(User user) {
        UserResponseDto response = new UserResponseDto();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setSurname(user.getSurname());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setBirthday(user.getBirthday());
        response.setBalance(user.getBalance());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        response.setModifiedAt(user.getModifiedAt());
        return response;
    }

    public User toEntity(UserRequestDto request) {
        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        user.setBirthday(request.getBirthday());
        user.setBalance(request.getBalance());
        user.setRole(request.getRole());
        return user;
    }
}
