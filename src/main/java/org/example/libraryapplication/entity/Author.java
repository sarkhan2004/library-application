package org.example.libraryapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String surname;

    @Column(length = 2000)
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


}
