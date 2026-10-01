package org.v0x00v.usersignin.Repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.v0x00v.usersignin.Models.User;

public interface UserRepository extends Repository<User, Long> {

    Page<User> findAll(Pageable pageable);

    User findByEmail(String email);
}
