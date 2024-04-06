package com.x12.project11x12.register;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.x12.project11x12.facades.encryptations.EncoderFacade;
import com.x12.project11x12.roles.Role;
import com.x12.project11x12.roles.RoleRepository;
import com.x12.project11x12.users.User;
import com.x12.project11x12.users.UserRepository;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EncoderFacade encoderFacade;

    public User registerUser(RegisterDTO registerDTO) {
        Role userRole = roleRepository.findByName("ROLE_USER");

        User user = new User();
        user.setUsername(registerDTO.getUsername());

        String passwordBase64 = encoderFacade.encode("base64", registerDTO.getPassword());
       
        String passwordDecoded = encoderFacade.decode("base64", passwordBase64);

        String passwordEncoded = encoderFacade.encode("bcrypt", passwordDecoded);

        user.setPassword(passwordEncoded);

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}