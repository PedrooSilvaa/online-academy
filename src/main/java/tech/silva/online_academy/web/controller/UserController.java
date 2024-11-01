package tech.silva.online_academy.web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.online_academy.entity.UserEntity;
import tech.silva.online_academy.service.UserService;
import tech.silva.online_academy.web.dto.UserCreateDto;
import tech.silva.online_academy.web.dto.UserResponseDto;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody @Valid UserCreateDto dto){
        UserEntity user = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.ToResponse(user));
    }
}
