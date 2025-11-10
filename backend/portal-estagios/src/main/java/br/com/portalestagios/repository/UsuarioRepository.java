package br.com.portalestagios.repository;

import br.com.portalestagios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário

    // Adicionado para permitir autenticação simples pelo backend
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}