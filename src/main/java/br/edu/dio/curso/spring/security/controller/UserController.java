package br.edu.dio.curso.spring.security.controller;

import br.edu.dio.curso.spring.security.model.User;
import br.edu.dio.curso.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity postUser(@RequestBody User user){
        service.createUser(user);
        return ResponseEntity.created(URI.create("/users")).build();
    }

}
