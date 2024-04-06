package com.x12.project11x12.security;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.x12.project11x12.users.User;
import com.x12.project11x12.users.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private UserRepository userRepository;

/*     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return repository
                .findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));

    } */

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userOptional = userRepository.findByUsername(username);
    if (userOptional.isEmpty()) {
        throw new UsernameNotFoundException("User not found");
    }
    User user = userOptional.get();
    return new SecurityUser(user);
}

}
