package org.example.libraryapplication.dto.book;

import lombok.Data;
import org.example.libraryapplication.enums.BookCategory;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class RequestBody {
    private String name;
    private BookCategory bookCategory;
    private String description;
    private BigDecimal price;
    private Set<Long> authorIds;
}
