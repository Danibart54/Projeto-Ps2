package main.java.br.com.portalestagios.controller;

import br.com.portalestagios.entity.Vaga;
import br.com.portalestagios.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<Vaga> getAllVagas() {
        return vagaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> getVagaById(@PathVariable Long id) {
        return vagaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vaga createVaga(@RequestBody Vaga vaga) {
        return vagaService.save(vaga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> updateVaga(@PathVariable Long id, @RequestBody Vaga vaga) {
        return vagaService.update(id, vaga)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaga(@PathVariable Long id) {
        if (vagaService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}