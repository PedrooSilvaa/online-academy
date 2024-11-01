package tech.silva.online_academy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.silva.online_academy.Repository.IUserRepository;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

}
