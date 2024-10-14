package br.edu.dio.curso.spring.security.controller;

import br.edu.dio.curso.spring.security.dto.UserDTO;
import br.edu.dio.curso.spring.security.model.User;
import br.edu.dio.curso.spring.security.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
@Tag(name = "Gestão de usuários", description = "Operações relacionadas aos usuários")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(
            summary = "Cadastro de usuários",
            description = "Endpoint para cadastro de usuários")
    @ApiResponse(
            responseCode = "201",
            description = "Cadastro realizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @PostMapping
    public ResponseEntity postUser(@RequestBody UserDTO userDTO){
        User userEntity = modelMapper.map(userDTO, User.class);
        service.createUser(userEntity);
        return ResponseEntity.created(URI.create("/users")).build();
    }

}
