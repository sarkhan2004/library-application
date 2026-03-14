package org.example.libraryapplication.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.author.AuthorResponseDto;
import org.example.libraryapplication.dto.book.BookRequestDto;
import org.example.libraryapplication.dto.book.BookResponseDto;
import org.example.libraryapplication.entity.Author;
import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.exceptions.BookNotFoundException;
import org.example.libraryapplication.mapper.BookMapper;
import org.example.libraryapplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    private final BookMapper bookMapper;

    public BookResponseDto createBook(BookRequestDto request) {

        Book book = bookMapper.toEntity(request);
        Set<Long> authorIds = request.getAuthorIds();
        Long id=authorIds.iterator().next();
        Author author=authorService.getAuthorByIdEntity(id);

        book.setCreatingDate(LocalDateTime.now());
        book.setAuthors(Set.of(author));

        Book savedBook = bookRepository.save(book);

        return bookMapper.toDto(savedBook);
    }

    @Transactional
    public BookResponseDto findById(Long id) {
        Book foundedBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));

        foundedBook.setViews(foundedBook.getViews());

        return bookMapper.toDto(foundedBook);
    }

    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    public BookResponseDto updateBook(Long id, BookRequestDto request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));

        book.setName(request.getName());
        book.setCategory(request.getBookCategory());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());

        Book updatedBook = bookRepository.save(book);

        return bookMapper.toDto(updatedBook);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }

}
