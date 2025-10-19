package br.com.portalestagios.service;

import br.com.portalestagios.dao.AreaInteresseDAO;
import br.com.portalestagios.entity.AreaInteresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaInteresseService {

    private final AreaInteresseDAO areaInteresseDAO;

    @Autowired
    public AreaInteresseService(AreaInteresseDAO areaInteresseDAO) {
        this.areaInteresseDAO = areaInteresseDAO;
    }

    public List<AreaInteresse> findAll() {
        return areaInteresseDAO.findAll();
    }

    public AreaInteresse findById(Long id) {
        return areaInteresseDAO.findById(id).orElse(null);
    }

    public AreaInteresse save(AreaInteresse areaInteresse) {
        return areaInteresseDAO.save(areaInteresse);
    }

    public void deleteById(Long id) {
        areaInteresseDAO.deleteById(id);
    }
}