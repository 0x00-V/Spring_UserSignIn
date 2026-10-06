package org.v0x00v.usersignin.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.v0x00v.usersignin.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}