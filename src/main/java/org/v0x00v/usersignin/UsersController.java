package org.v0x00v.usersignin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.v0x00v.usersignin.Models.*;
import org.v0x00v.usersignin.Repositories.UserRepository;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserRepository repository;
    public UsersController(UserRepository repository)
    {
        this.repository = repository;
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
        User  user = repository.findByEmail(signInForm.getEmail());
        if(user == null)
        {
            return signInForm.getEmail()+" not found.";
        }
        return "Entered Details: " + signInForm.getEmail() +" "+ signInForm.getPassword() + "\nPassword Match Real User: " + encoder.matches(signInForm.getPassword(), user.getPassword());
    }

}
