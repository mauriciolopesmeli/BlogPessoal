package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start() {
        usuarioRepository.deleteAll();
        usuarioRepository.save(new Usuario(0L, "Mauricio Lopes", "mauricio@email.com", "12345612", "foto.jpg"));
        usuarioRepository.save(new Usuario(0L, "Tico Lopes", "tico@email.com", "14790012", "foto.jpg"));
        usuarioRepository.save(new Usuario(0L, "Tuco Lopes", "tuco@email.com", "18273312", "foto.jpg"));
        usuarioRepository.save(new Usuario(0L, "Tica Lopes", "tica@email.com", "13516312", "foto.jpg"));
    }

    @Test
    @DisplayName("Retorna 1 usuário.")
    public void deveRetornarUmUsuario() {
        Optional<Usuario> usuario = usuarioRepository.findByUsuario("mauricio@email.com");
        assertEquals("mauricio@email.com", usuario.get().getUsuario());
    }

    @AfterAll
    public void end() {
        usuarioRepository.deleteAll();
    }
}
