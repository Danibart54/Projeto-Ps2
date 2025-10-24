package br.com.portalestagios.service;

import br.com.portalestagios.entity.Vaga;
import br.com.portalestagios.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;
    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> findById(Long id) {
        return vagaRepository.findById(id);
    }

    public Vaga save(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public Optional<Vaga> update(Long id, Vaga vaga) {
        return vagaRepository.findById(id).map(existing -> {
            vaga.setId(existing.getId());
            return vagaRepository.save(vaga);
        });
    }

    public boolean delete(Long id) {
        if (vagaRepository.existsById(id)) {
            vagaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
