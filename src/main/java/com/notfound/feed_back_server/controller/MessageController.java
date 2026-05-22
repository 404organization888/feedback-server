package com.notfound.feed_back_server.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.feed_back_server.dto.MessageReponseDTO;
import com.notfound.feed_back_server.dto.MessageRequestDTO;
import com.notfound.feed_back_server.service.MessageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/all")
    public ResponseEntity<List<MessageReponseDTO>> getAllMessages() {
        List<MessageReponseDTO> messages = messageService.findAllMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMessage(@Valid @RequestBody MessageRequestDTO request) {
        try {
            messageService.createMessage(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Message created successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create message");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMessage(@RequestParam LocalDateTime createdAt) {
        try {
            messageService.deleteMessage(createdAt);
            return ResponseEntity.status(HttpStatus.OK).body("Message deleted successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete message");
        }
    }
}
