package org.example.libraryapplication.dto.user;

import lombok.Data;
import org.example.libraryapplication.enums.Role;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private LocalDate birthday;
    private BigDecimal balance;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
