package br.edu.dio.curso.spring.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Home API")
@RestController
public class HomeController {

    @Operation(
            summary = "Home",
            description = "Exibe messagem de boas vindas")
    @ApiResponse(
            responseCode = "200",
            description = "Messagem de boas vindas exibida com sucesso",
            content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE))
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }

}
