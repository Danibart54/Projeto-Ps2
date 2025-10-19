package main.java.br.com.portalestagios.repository;

import br.com.portalestagios.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    // Define methods for database operations related to Inscricao
}

