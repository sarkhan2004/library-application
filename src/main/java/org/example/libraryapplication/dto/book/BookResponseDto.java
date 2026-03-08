package org.example.libraryapplication.dto.book;

import lombok.Data;
import org.example.libraryapplication.enums.BookCategory;

import java.math.BigDecimal;

@Data
public class BookResponseDto {
    private String name;
    private BookCategory bookCategory;
    private String description;
    private BigDecimal price;
}
