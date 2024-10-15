package br.edu.dio.curso.spring.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private JWTFilter jwtFilter;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs",         // Documentação em json
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",    // Documentação em yaml
            "/swagger-ui/**",
            "/swagger-ui.html"     // Interface swagger
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(c -> c.disable())
                .cors(c -> c.disable())
                .headers(h -> h.frameOptions(f -> f.disable()))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(req -> {
                        req.requestMatchers(SWAGGER_WHITELIST).permitAll();
                        req.requestMatchers("/h2-console/**").permitAll();
                        req.requestMatchers(HttpMethod.GET, "/").permitAll();
                        req.requestMatchers(HttpMethod.POST, "/login").permitAll();
                        req.requestMatchers(HttpMethod.POST, "/users").permitAll();
                        req.requestMatchers(HttpMethod.GET, "/users").hasAnyRole("USERS", "MANAGERS");
                        req.requestMatchers("/managers").hasRole("MANAGERS");
                        req.anyRequest().authenticated();
                })
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

//    @Bean //HABILITANDO ACESSAR O H2-DATABSE NA WEB
//    public ServletRegistrationBean<HttpServlet> h2servletRegistration(){
//        ServletRegistrationBean<HttpServlet> registrationBean = new ServletRegistrationBean( new WebServlet());
//        registrationBean.addUrlMappings("/h2-console/*");
//        return registrationBean;
//    }

}