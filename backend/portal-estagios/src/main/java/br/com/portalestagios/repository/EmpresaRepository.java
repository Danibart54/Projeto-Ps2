package br.com.portalestagios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.portalestagios.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> { }
