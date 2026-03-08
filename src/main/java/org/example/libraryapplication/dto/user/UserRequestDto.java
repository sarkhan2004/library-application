package org.example.libraryapplication.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.example.libraryapplication.enums.Role;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UserRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 1, max = 100, message = "Surname must be between 1 and 100 characters")
    private String surname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid")
    private String phoneNumber;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @Past(message = "Birthday must be in the past")
    private LocalDate birthday;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be greater than or equal to 0")
    private BigDecimal balance;

    @NotNull(message = "Role is required")
    private Role role;
}
