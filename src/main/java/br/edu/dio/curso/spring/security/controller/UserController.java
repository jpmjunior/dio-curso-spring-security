package br.edu.dio.curso.spring.security.controller;

import br.edu.dio.curso.spring.security.dto.UserDTO;
import br.edu.dio.curso.spring.security.model.User;
import br.edu.dio.curso.spring.security.service.UserService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserDTO userDTO){
        User userEntity = modelMapper.map(userDTO, User.class);
        service.createUser(userEntity);
        return ResponseEntity.created(URI.create("/users")).build();
    }

}
