package org.example.libraryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.libraryapplication.enums.BookCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    private String name;
    private Long views = 0L;
    private Double rating = 0.0;
    private String description;
    private BigDecimal price;
    private LocalDateTime creatingDate;

    @ManyToMany(mappedBy = "books")
    private  Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private List<Comment> comments;

}
