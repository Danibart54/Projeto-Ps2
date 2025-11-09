package com.portalestagios.service;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.portalestagios.model.Estudante;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class CurriculoService {

    public byte[] gerarCurriculoPDF(Estudante estudante) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Currículo - " + estudante.getNome()).setBold().setFontSize(18));
        document.add(new Paragraph("E-mail: " + estudante.getEmail()));
        document.add(new Paragraph("Curso: " + estudante.getCurso()));
        document.add(new Paragraph("Áreas de Interesse: " + estudante.getAreasInteresse()));

        document.add(new Paragraph("\nHistórico de Candidaturas:").setBold());
        if (estudante.getHistoricoCandidaturas() != null) {
            for (String vaga : estudante.getHistoricoCandidaturas()) {
                document.add(new Paragraph("- " + vaga));
            }
        }

        document.close();
        return baos.toByteArray();
    }
}
