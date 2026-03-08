package org.example.libraryapplication.controller;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.service.BookService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public org.example.libraryapplication.dto.book.ResponseBody createBook(@RequestBody org.example.libraryapplication.dto.book.RequestBody book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }


}
