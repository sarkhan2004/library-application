package org.example.libraryapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.author.AuthorRequestDto;
import org.example.libraryapplication.dto.author.AuthorResponseDto;
import org.example.libraryapplication.entity.Author;
import org.example.libraryapplication.exceptions.AuthorNotFoundException;
import org.example.libraryapplication.mapper.AuthorMapper;
import org.example.libraryapplication.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorResponseDto createAuthor(AuthorRequestDto request) {
        Author author = authorMapper.toEntity(request);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDto(savedAuthor);
    }

    public AuthorResponseDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found"));
        return authorMapper.toDto(author);
    }

    public Author getAuthorByIdEntity(Long id) {
       return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found"));

    }

    public List<AuthorResponseDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDto)
                .toList();
    }

    public AuthorResponseDto updateAuthor(Long id, AuthorRequestDto request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found"));

        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setBiography(request.getBiography());

        Author updatedAuthor = authorRepository.save(author);
        return authorMapper.toDto(updatedAuthor);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Author with id " + id + " not found");
        }
        authorRepository.deleteById(id);
    }
}
