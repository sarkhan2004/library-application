package org.example.libraryapplication.mapper;

import org.example.libraryapplication.dto.book.RequestBody;
import org.example.libraryapplication.dto.book.ResponseBody;
import org.example.libraryapplication.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public ResponseBody toDto(Book book) {
        ResponseBody response = new ResponseBody();
        response.setName(book.getName());
        response.setBookCategory(book.getCategory());
        response.setPrice(book.getPrice());
        response.setDescription(book.getDescription());

        return response;
    }

    public Book toEntity(RequestBody request) {
        Book book = new Book();

        book.setName(request.getName());
        book.setCategory(request.getBookCategory());
        book.setPrice(request.getPrice());
        book.setCategory(request.getBookCategory());

        return book;
    }
}

