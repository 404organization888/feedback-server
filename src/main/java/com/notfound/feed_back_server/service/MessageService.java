package com.notfound.feed_back_server.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.notfound.feed_back_server.dto.MessageReponseDTO;
import com.notfound.feed_back_server.dto.MessageRequestDTO;
import com.notfound.feed_back_server.entity.Message;
import com.notfound.feed_back_server.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<MessageReponseDTO> findAllMessages() {
        return messageRepository.findAll().stream()
                .map(message -> MessageReponseDTO.builder()
                .information(message.getInformation())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .build()
                )
                .toList();
    }

    public void deleteMessage(LocalDateTime createdAt) {
        messageRepository.deleteByCreatedAt(createdAt);
    }

    public void createMessage(MessageRequestDTO messageRequestDTO) {
        Message newMessage = Message.builder()
                .information(messageRequestDTO.getInformation())
                .content(messageRequestDTO.getContent())
                .build();
        messageRepository.save(newMessage);
    }

}
