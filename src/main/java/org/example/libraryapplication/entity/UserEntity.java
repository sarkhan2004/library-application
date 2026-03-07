package org.example.libraryapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
public class UserEntity {

    private Long id;

    private String name;
}
