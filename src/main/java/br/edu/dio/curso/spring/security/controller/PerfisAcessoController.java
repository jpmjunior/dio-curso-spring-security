package br.edu.dio.curso.spring.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "tokenJWT")
@Tag(name = "Perfis de acesso", description = "Operações para teste dos perfis de acesso")
@RestController
public class PerfisAcessoController {

    @Operation(
            summary = "Perfil USERS",
            description = "Verifica se usuário logado tem perfil USERS")
    @ApiResponse(
            responseCode = "200",
            description = "Usuário com perfil USERS autorizado",
            content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE))
    @ApiResponse(
            responseCode = "403",
            description = "Usuário não autorizado",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }

    @Operation(
            summary = "Perfil MANAGERS",
            description = "Verifica se usuário logado tem perfil MANAGERS")
    @ApiResponse(
            responseCode = "200",
            description = "Usuário com perfil MANAGERS autorizado",
            content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE))
    @ApiResponse(
            responseCode = "403",
            description = "Usuário não autorizado",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }

}
