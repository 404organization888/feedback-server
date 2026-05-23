package com.notfound.feed_back_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.notfound.feed_back_server.entity.User;
import com.notfound.feed_back_server.repository.UserRepository;

@SpringBootApplication
public class FeedBackServerApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(FeedBackServerApplication.class, args);

        UserRepository userRepo = context.getBean(UserRepository.class);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        if (!userRepo.existsByUserName("admin")) {
            User admin = User.builder()
                    .userName("admin")
                    .password(encoder.encode("manh123zkxnxx"))
                    .build();

            userRepo.save(admin);
            System.out.println("Admin created!");
        }
    }
}
