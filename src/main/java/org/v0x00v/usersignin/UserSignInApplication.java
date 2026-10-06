package org.v0x00v.usersignin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.v0x00v.usersignin.Models.*;
import org.v0x00v.usersignin.Repositories.UserRepository;

import javax.sql.DataSource;
import java.util.NoSuchElementException;

@SpringBootApplication
public class UserSignInApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSignInApplication.class, args);


    }

    @Bean
    CommandLineRunner runner(UserRepository repository) {
        return args -> {

            System.out.println("RUNNER STARTED");

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

            User user = new User();
            user.setName("User1");
            user.setEmail("business.danielthomas@outlook.com");
            user.setPassword(encoder.encode("1234"));

            System.out.println("About to save...");

            User saved = repository.save(user);

            System.out.println("SAVED!");
            System.out.println("ID: " + saved.getId());
            System.out.println("Email: " + saved.getEmail());
            System.out.println("Password Comparison: "+ encoder.matches("1234", user.getPassword()));
            System.out.println("Password Comparison: "+ encoder.matches("12345", user.getPassword()));
        };
    }

}
