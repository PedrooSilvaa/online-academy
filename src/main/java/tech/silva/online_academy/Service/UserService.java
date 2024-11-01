package tech.silva.online_academy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.silva.online_academy.Entity.UserEntity;
import tech.silva.online_academy.Repository.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;


}
