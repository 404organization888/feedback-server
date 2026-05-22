package com.notfound.feed_back_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notfound.feed_back_server.dto.UserRequestDTO;
import com.notfound.feed_back_server.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/404admin")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserRequestDTO request) {
        try {
            String token = userService.login(request.getUsername(), request.getPassword());
            return ResponseEntity.status(HttpStatus.OK).body(token);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
