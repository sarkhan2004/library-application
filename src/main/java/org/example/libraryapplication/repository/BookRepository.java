package org.example.libraryapplication.repository;

import org.example.libraryapplication.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<BookEntity> books = new ArrayList<>();
    private Long id = 1L;

    public List<BookEntity> findAll() {
        return books;
    }

    public BookEntity save(BookEntity book) {
        book.setId(id);
        id++;
        books.add(book);
        return book;
    }

    public Optional<BookEntity> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
