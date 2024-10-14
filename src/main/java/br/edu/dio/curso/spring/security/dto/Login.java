package br.edu.dio.curso.spring.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Login", description = "Dados de login do usuário")
public class Login {

    @Schema(description = "Nome de usuário", example = "josejunior")
    private String username;

    @Schema(description = "Senha", example = "senha1234")
    private String password;

}
