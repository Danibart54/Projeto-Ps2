package com.portalestagios.controller;

import com.portalestagios.model.Estudante;
import com.portalestagios.service.CurriculoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {

    private final CurriculoService curriculoService;

    public CurriculoController(CurriculoService curriculoService) {
        this.curriculoService = curriculoService;
    }

    @PostMapping("/gerar")
    public ResponseEntity<byte[]> gerarCurriculo(@RequestBody Estudante estudante) {
        byte[] pdf = curriculoService.gerarCurriculoPDF(estudante);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
