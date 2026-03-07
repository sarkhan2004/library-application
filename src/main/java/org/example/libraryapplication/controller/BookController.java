package org.example.libraryapplication.controller;

import org.example.libraryapplication.entity.BookEntity;
import org.example.libraryapplication.exceptions.BookNotFoundException;
import org.example.libraryapplication.repository.BookRepository;
import org.example.libraryapplication.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public BookEntity  getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }


}
