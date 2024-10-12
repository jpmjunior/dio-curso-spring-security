package br.edu.dio.curso.spring.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String username;
    private String password;
    private List<String> roles;

}
