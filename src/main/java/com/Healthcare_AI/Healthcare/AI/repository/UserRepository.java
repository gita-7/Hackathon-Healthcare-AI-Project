package com.Healthcare_AI.Healthcare.AI.repository;

import com.Healthcare_AI.Healthcare.AI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByName(String name);
}


