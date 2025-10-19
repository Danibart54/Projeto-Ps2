package main.java.br.com.portalestagios.service;

import br.com.portalestagios.entity.Estudante;
import br.com.portalestagios.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> listarEstudantes() {
        return estudanteRepository.findAll();
    }

    public Estudante buscarEstudantePorId(Long id) {
        return estudanteRepository.findById(id).orElse(null);
    }

    public Estudante salvarEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public void excluirEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }
}
