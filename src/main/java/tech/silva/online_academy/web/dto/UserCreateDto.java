package tech.silva.online_academy.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateDto (
        @NotBlank
        String name,
        @NotBlank
        @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
        String username,
        @Size(min = 6)
        String password
){
}
