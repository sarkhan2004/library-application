package org.example.libraryapplication.service;

import lombok.RequiredArgsConstructor;
import org.example.libraryapplication.dto.book.RequestBody;
import org.example.libraryapplication.dto.book.ResponseBody;
import org.example.libraryapplication.entity.Book;
import org.example.libraryapplication.exceptions.BookNotFoundException;
import org.example.libraryapplication.mapper.BookMapper;
import org.example.libraryapplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public ResponseBody createBook(RequestBody request) {

        Book book = bookMapper.toEntity(request);

        book.setCreatingDate(LocalDateTime.now());

        Book savedBook = bookRepository.save(book);

        return bookMapper.toDto(savedBook);
    }

    public ResponseBody findById(Long id) {
        Book foundedBook = bookRepository.findById(id).get();

        return bookMapper.toDto(foundedBook);
    }


}
