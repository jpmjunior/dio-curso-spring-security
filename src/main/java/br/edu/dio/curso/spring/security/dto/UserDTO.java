package br.edu.dio.curso.spring.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "User", description = "Dados de usuário")
public class UserDTO {

    @Schema(description = "Nome do usuário", example = "José Júnior")
    private String name;

    @Schema(description = "Nome de usuário", example = "josejunior")
    private String username;

    @Schema(description = "Senha do usuário", example = "senha1234")
    private String password;

    @Schema(description = "Perfis de acesso", example = "[\"USERS\",\"MANAGERS\"]")
    private List<String> roles;

}
