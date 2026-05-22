package com.notfound.feed_back_server.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notfound.feed_back_server.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    void deleteByCreatedAt(LocalDateTime createdAt);
}
