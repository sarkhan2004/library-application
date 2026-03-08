package org.example.libraryapplication.dto.comment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDto {

    private Long id;

    private String text;

    private Double rating;

    private String userName;

    private String bookName;

    private LocalDateTime createdDate;

}
