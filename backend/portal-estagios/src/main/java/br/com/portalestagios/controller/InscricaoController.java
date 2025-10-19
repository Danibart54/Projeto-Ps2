package main.java.br.com.portalestagios.controller;

import br.com.portalestagios.entity.Inscricao;
import br.com.portalestagios.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public List<Inscricao> getAllInscricoes() {
        return inscricaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> getInscricaoById(@PathVariable Long id) {
        return inscricaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscricao createInscricao(@RequestBody Inscricao inscricao) {
        return inscricaoService.save(inscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> updateInscricao(@PathVariable Long id, @RequestBody Inscricao inscricao) {
        return inscricaoService.update(id, inscricao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscricao(@PathVariable Long id) {
        if (inscricaoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}