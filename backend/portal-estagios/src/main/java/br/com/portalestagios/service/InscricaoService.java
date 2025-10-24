package br.com.portalestagios.service;

import br.com.portalestagios.entity.Inscricao;
import br.com.portalestagios.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    public Optional<Inscricao> findById(Long id) {
        return inscricaoRepository.findById(id);
    }

    public Inscricao save(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public Optional<Inscricao> update(Long id, Inscricao inscricao) {
        return inscricaoRepository.findById(id).map(existing -> {
            inscricao.setId(existing.getId());
            return inscricaoRepository.save(inscricao);
        });
    }

    public boolean delete(Long id) {
        if (inscricaoRepository.existsById(id)) {
            inscricaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
