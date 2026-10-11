package org.v0x00v.usersignin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import org.v0x00v.usersignin.Models.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    @Autowired
    private SecurityContextRepository securityContextRepository;

    public UsersController(AuthenticationManager authenticationManager, UserService userService)
    {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @GetMapping("test_endpoint")
    public String testEndpoint()
    {
        return "{\"Success\": true}";
    }

    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody SignIn signInForm, HttpServletRequest request, HttpServletResponse response)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInForm.getUsername(),
                        signInForm.getPassword()
                )
        );
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        return ResponseEntity.ok("Login Successful");
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("User registered");
    }


}
