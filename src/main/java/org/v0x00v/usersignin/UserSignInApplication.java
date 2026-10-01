package org.v0x00v.usersignin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.NoSuchElementException;

@SpringBootApplication
public class UserSignInApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSignInApplication.class, args);


    }

    /*@Bean
    CommandLineRunner runner(UserRepository repository)
    {
        return args -> {
            User user = new User();
            user.setName("Daniel");
            user.setEmail("danithom2003@outlook.com");
            repository.save(user);
            User saved = repository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        };
    }*/

}
