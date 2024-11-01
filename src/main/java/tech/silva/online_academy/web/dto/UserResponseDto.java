package tech.silva.online_academy.web.dto;

import tech.silva.online_academy.Entity.Role;

public record UserResponseDto(
        Long id,
        String name,
        String username,
        Long registrationNumber,
        Role role
) {
}
