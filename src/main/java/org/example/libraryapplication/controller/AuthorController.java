package org.example.libraryapplication.controller;

import org.example.libraryapplication.dto.author.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @GetMapping
    public ResponseBody getAuthors() {


    }




}
