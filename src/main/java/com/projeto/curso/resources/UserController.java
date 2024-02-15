package com.projeto.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "José", "jose@gmail.com", "40028922", "1234");
        // User user2 = new User(null, "Dudu", "dudu@gmail.com", "3494000","abcde");

        // ResponseEntity.ok().body(user2);
        return ResponseEntity.ok().body(user);

    }
}
