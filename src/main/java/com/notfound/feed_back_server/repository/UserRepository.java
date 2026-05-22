package com.notfound.feed_back_server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notfound.feed_back_server.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    boolean existsByUserName(String username);
}
