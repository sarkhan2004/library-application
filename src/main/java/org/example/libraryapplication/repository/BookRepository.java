package org.example.libraryapplication.repository;

import org.example.libraryapplication.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();
    private Long id = 1L;

    public List<Book> findAll() {
        return books;
    }

    public Book save(Book book) {
        book.setId(id);
        id++;
        books.add(book);
        return book;
    }

    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
