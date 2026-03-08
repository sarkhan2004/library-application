package org.example.libraryapplication.mapper;

import org.example.libraryapplication.dto.author.AuthorRequestDto;
import org.example.libraryapplication.dto.author.AuthorResponseDto;
import org.example.libraryapplication.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorResponseDto toDto(Author author) {
        AuthorResponseDto response = new AuthorResponseDto();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setSurname(author.getSurname());
        response.setBiography(author.getBiography());
        return response;
    }

    public Author toEntity(AuthorRequestDto request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setBiography(request.getBiography());
        return author;
    }
}
