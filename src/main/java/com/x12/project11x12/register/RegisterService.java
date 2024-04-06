package com.x12.project11x12.register;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.x12.project11x12.roles.Role;
import com.x12.project11x12.roles.RoleRepository;
import com.x12.project11x12.users.User;
import com.x12.project11x12.users.UserRepository;


//   INICIAL  //

/* @Service
public class RegisterService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(RegisterDTO registerDTO) {

        Role userRole = roleRepository.findByName("ROLE_USER");

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
                
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        
        return userRepository.save(user);       

    }
} */


/* 
@Service
public class RegisterService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(RegisterDTO registerDTO) {
        
        String passwordDecoded = decodeBase64(registerDTO.getPassword());

        String passwordEncoded = passwordEncoder.encode(passwordDecoded);

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoded);

        Role userRole = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    private String decodeBase64(String base64EncodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedString);
        return new String(decodedBytes);
    }
} */


//   *** ULTIMA PRUEBA ***

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(RegisterDTO registerDTO) {

        Role userRole = roleRepository.findByName("ROLE_USER");
    
        User user = new User();
        user.setUsername(registerDTO.getUsername());
    
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(registerDTO.getPassword());
        String passwordDecoded = new String(decodedBytes);
    
        user.setPassword(passwordEncoder.encode(passwordDecoded)); 
        //user.setPassword(passwordDecoded); 
              
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        
        return userRepository.save(user);
    } 
    

//  * ULTIMA PRUEBA *



/*     @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(RegisterDTO registerDTO) {
  
        Role userRole = roleRepository.findByName("ROLE_USER");

        User user = new User();
        user.setUsername(registerDTO.getUsername());

        String base64Password = registerDTO.getPassword();
        byte[] decodedBytes = Base64.getDecoder().decode(base64Password);
        String decodedPassword = new String(decodedBytes);
        String bcryptPassword = passwordEncoder.encode(decodedPassword);
        user.setPassword(bcryptPassword);
              
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
        
        return userRepository.save(user);
    } */




/*        private String decodeBase64(String base64EncodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedString);
        return new String(decodedBytes);
    }  */


    // ANTERIOR 

   /*  public User registerUser(RegisterDTO registerDTO) {
        Role userRole = roleRepository.findByName("ROLE_USER");
    
        User user = new User();
        user.setUsername(registerDTO.getUsername());
    
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(registerDTO.getPassword());
        String passwordDecoded = new String(decodedBytes);
    
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoded = encoder.encode(passwordDecoded);
        user.setPassword(passwordEncoded);
    
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);
    
        return userRepository.save(user);
    } */


}