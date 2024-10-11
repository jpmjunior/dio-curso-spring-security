package br.edu.dio.curso.spring.security.repository;

import br.edu.dio.curso.spring.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = (:username)")
    public User findByUsername(@Param("username") String username);

}
