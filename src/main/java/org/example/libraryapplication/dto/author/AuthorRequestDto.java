package org.example.libraryapplication.dto.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorRequestDto {
    @NotBlank(message = "Author name is required")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @NotBlank(message = "Author surname is required")
    @Size(min = 1, max = 100, message = "Surname must be between 1 and 100 characters")
    private String surname;

    @Size(max = 2000, message = "Biography must not exceed 2000 characters")
    private String biography;

    private Set<Long> bookIds;
}
