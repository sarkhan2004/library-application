package org.example.libraryapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
public class BookEntity {

    private Long id;

    private String name;
    private BigDecimal price;
}
