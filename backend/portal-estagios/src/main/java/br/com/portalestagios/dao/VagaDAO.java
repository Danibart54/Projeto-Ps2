package br.com.portalestagios.dao;

import br.com.portalestagios.entity.JobOffer;
import br.com.portalestagios.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VagaDAO {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

    public Optional<JobOffer> findById(Long id) {
        return jobOfferRepository.findById(id);
    }

    public JobOffer save(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public void deleteById(Long id) {
        jobOfferRepository.deleteById(id);
    }
}