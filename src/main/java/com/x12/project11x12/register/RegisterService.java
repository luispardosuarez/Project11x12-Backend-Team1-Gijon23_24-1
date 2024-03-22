package com.x12.project11x12.register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.x12.project11x12.roles.RoleRepository;
import com.x12.project11x12.users.User;
import com.x12.project11x12.users.UserRepository;
@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public User registerUser(RegisterDTO registerDTO) {
/*         Group group = groupRepository.findByGroupName(registerDTO.getGroupName());
        if (group == null) {
            group = new Group();
            group.setGroupName(registerDTO.getGroupName());
            group = groupRepository.save(group);
        }
        // Busca rol de Admin
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
 */
        // Crea nuevo usuario
/*         User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setUserEmail(registerDTO.getEmail());
        return userRepository.save(user); */

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setUserEmail(registerDTO.getEmail());
        return userRepository.save(user); 
        

    }
}