package org.example.libraryapplication.entity;

import lombok.*;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String name;
    private String surname;
    private Date birthday;

}
