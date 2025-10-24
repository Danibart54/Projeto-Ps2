package br.com.portalestagios.repository;

import br.com.portalestagios.entity.Estudante; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    // Define methods for database operations related to Estudante
}
