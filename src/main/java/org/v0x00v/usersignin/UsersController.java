package org.v0x00v.usersignin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.v0x00v.usersignin.Models.*;
import org.v0x00v.usersignin.Repositories.UserRepository;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserRepository repository;
    private final UserService userService;
    public UsersController(UserRepository repository, UserService userService)
    {
        this.repository = repository;
        this.userService = userService;
    }

    @GetMapping("test_endpoint")
    public String testEndpoint()
    {
        return "{\"Success\": true}";
    }

    @PostMapping("signin")
    String signIn(@RequestBody SignIn signInForm)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(24);
        User  user = repository.findByUsername(signInForm.getUsername());
        if(user == null)
        {
            return signInForm.getUsername()+" not found.";
        }
        return "Entered Details: " + signInForm.getUsername() +" "+ signInForm.getPassword() + "\nPassword Match Real User: " + encoder.matches(signInForm.getPassword(), user.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("User registered");
    }


}
