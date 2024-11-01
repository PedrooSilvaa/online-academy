package tech.silva.online_academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.online_academy.entity.UserEntity;
import tech.silva.online_academy.repository.IUserRepository;
import tech.silva.online_academy.exception.UserUniqueViolationException;
import tech.silva.online_academy.web.dto.UserCreateDto;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Transactional
    public UserEntity createUser(UserCreateDto dto){
        try {
            UserEntity user = new UserEntity();
            user.setName(dto.name());
            user.setUsername(dto.username());
            user.setPassword(dto.password());
            user.setRegistrationNumber(generateUniqueNumber());
            return userRepository.save(user);
        }catch (DataIntegrityViolationException ex){
            throw new UserUniqueViolationException("User not found. Please check the user ID or username and try again.");
        }
    }

    public Long generateUniqueNumber() {
        Random random = new Random();
        Long number;
        boolean exists;

        do {
            number = (long) random.nextInt(10000);
            Optional<UserEntity> userExists = userRepository.findByRegistrationNumber(number);
            exists = userExists.isPresent();
        }while (exists);
        return number;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
