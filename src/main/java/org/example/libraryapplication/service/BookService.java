package org.example.libraryapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.book.BookRequestDto;
import org.example.libraryapplication.dto.book.BookResponseDto;
import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.exceptions.BookNotFoundException;
import org.example.libraryapplication.mapper.BookMapper;
import org.example.libraryapplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookResponseDto createBook(BookRequestDto request) {

        Book book = bookMapper.toEntity(request);

        book.setCreatingDate(LocalDateTime.now());

        Book savedBook = bookRepository.save(book);

        return bookMapper.toDto(savedBook);
    }

    public BookResponseDto findById(Long id) {
        Book foundedBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id " + id + " not found"));

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
