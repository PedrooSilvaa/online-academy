package tech.silva.online_academy.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.silva.online_academy.entity.UserEntity;
import tech.silva.online_academy.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByUsername(username);
        return new JwtUserDetails(user);
    }

    public JwtToken getTokenAuthenticated(String username) {
        UserEntity user = userService.findByUsername(username);
        return JwtUtils.createToken(username, user.getRole().name().substring("ROLE_".length()));
    }

}
