package org.example.libraryapplication.mapper;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.author.AuthorRequestDto;
import org.example.libraryapplication.dto.author.AuthorResponseDto;
import org.example.libraryapplication.entity.Author;
import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    private final BookRepository bookRepository;

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
