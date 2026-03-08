package org.example.libraryapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;


    private Double rating;

    private LocalDateTime createdDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;



}
