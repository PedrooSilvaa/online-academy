package tech.silva.online_academy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.online_academy.Entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
