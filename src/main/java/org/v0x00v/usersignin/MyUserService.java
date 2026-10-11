package org.v0x00v.usersignin;

import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.v0x00v.usersignin.Models.User;
import org.v0x00v.usersignin.Repositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> user = repository.findByUsername(username);
        if(user.isPresent()){
            var userObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }

}
