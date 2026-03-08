package org.example.libraryapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.entity.User;
import org.example.libraryapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }


    
}
