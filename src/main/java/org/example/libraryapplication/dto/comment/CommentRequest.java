package org.example.libraryapplication.dto.comment;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CommentRequest {

    private Long bookId;

    private Long userId;

    private String text;

    @Min(1)
    @Max(5)
    private Double rating;
}
