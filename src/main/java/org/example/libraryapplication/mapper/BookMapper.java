package org.example.libraryapplication.mapper;

import org.example.libraryapplication.dto.book.BookRequestDto;
import org.example.libraryapplication.dto.book.BookResponseDto;
import org.example.libraryapplication.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponseDto toDto(Book book) {
        BookResponseDto response = new BookResponseDto();
        response.setName(book.getName());
        response.setBookCategory(book.getCategory());
        response.setPrice(book.getPrice());
        response.setDescription(book.getDescription());

        return response;
    }

    public Book toEntity(BookRequestDto request) {
        Book book = new Book();

        book.setName(request.getName());
        book.setCategory(request.getBookCategory());
        book.setPrice(request.getPrice());
        book.setDescription(request.getDescription());

        return book;
    }
}

