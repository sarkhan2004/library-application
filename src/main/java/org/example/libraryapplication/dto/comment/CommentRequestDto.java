package org.example.libraryapplication.dto.comment;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequestDto {

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    @NotBlank
    private String text;

    @NotNull
    @Min(1)
    @Max(5)
    private Double rating;
}
