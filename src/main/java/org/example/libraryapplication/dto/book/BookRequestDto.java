package org.example.libraryapplication.dto.book;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.example.libraryapplication.enums.BookCategory;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class BookRequestDto {
    @NotBlank(message = "Book name is required")
    @Size(min = 1, max = 255, message = "Book name must be between 1 and 255 characters")
    private String name;

    @NotNull(message = "Book category is required")
    private BookCategory bookCategory;

    @Size(max = 5000, message = "Description must not exceed 5000 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than or equal to 0")
    private BigDecimal price;

    private Set<Long> authorIds;
}
