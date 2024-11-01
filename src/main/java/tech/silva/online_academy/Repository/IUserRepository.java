package tech.silva.online_academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.online_academy.entity.UserEntity;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    Optional<UserEntity> findByRegistrationNumber(Long number);
}
