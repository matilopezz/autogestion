package com.autogestion1.autogestion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDatos {

    @Bean
    CommandLineRunner init(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepositorio.count() == 0) {
                Usuario user1 = new Usuario("user1", passwordEncoder.encode("pass123"), "John", "Doe");
                Usuario user2 = new Usuario("user2", passwordEncoder.encode("pass456"), "Jane", "Smith");
                usuarioRepositorio.save(user1);
                usuarioRepositorio.save(user2);
            }
        };
    }
}

