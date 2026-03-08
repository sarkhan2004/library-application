package org.example.libraryapplication.dto.author;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String biography;
}
