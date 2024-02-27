package com.talan.pfemanager.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.talan.pfemanager.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);
}
