package org.example.libraryapplication.service;

import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.exceptions.BookNotFoundException;
import org.example.libraryapplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        if (book.getName() == null || book.getName().isBlank()) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        if (book.getPrice() == null || book.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Book price cannot be null or less than or equal to zero");
        }
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }


}
