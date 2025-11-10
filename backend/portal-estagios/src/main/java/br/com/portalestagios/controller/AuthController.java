package br.com.portalestagios.controller;

import br.com.portalestagios.entity.Usuario;
import br.com.portalestagios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // payload: { "email": "...", "senha": "...", "tipo": "ESTUDANTE|EMPRESA|ADMIN" }
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String senha = body.get("senha");
        // tipo pode ser usado para validação adicional se necessário
        return usuarioRepository.findByEmailAndSenha(email, senha)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}