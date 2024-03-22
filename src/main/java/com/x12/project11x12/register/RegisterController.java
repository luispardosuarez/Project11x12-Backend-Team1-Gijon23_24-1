package com.x12.project11x12.register;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.x12.project11x12.users.User;

@RestController
@RequestMapping("${api-endpoint}")
public class RegisterController {
    RegisterService registerService;
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterDTO registerDTO) {
        User user = registerService.registerUser(registerDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}