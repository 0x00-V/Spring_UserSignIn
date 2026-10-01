package org.v0x00v.usersignin;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    User save(User user);
    Optional<User> findById(long id);
    User findByEmail(String email);
}
