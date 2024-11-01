package tech.silva.online_academy.web.dto;

import tech.silva.online_academy.entity.Role;
import tech.silva.online_academy.entity.UserEntity;

public record UserResponseDto(
        Long id,
        String name,
        String username,
        Long registrationNumber,
        Role role
) {
    public static UserResponseDto ToResponse(UserEntity user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getRegistrationNumber(),
                user.getRole()
        );
    }
}
