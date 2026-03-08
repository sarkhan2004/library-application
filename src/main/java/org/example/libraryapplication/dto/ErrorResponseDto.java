package org.example.libraryapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
}
