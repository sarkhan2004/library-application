package org.example.libraryapplication.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {

    private Long id;

    private String name;
    private String category;
    private String author;
    private String description;
    private BigDecimal price;
}
