package main.java.br.com.portal.dao;

import br.com.portal.model.JobOffer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class JobOfferDAO {

    private final EntityManager em;

    public JobOfferDAO(EntityManager em) {
        this.em = em;
    }

    public Optional<JobOffer> findById(Long id) {
        return Optional.ofNullable(em.find(JobOffer.class, id));
    }

    public List<JobOffer> findAll() {
        TypedQuery<JobOffer> q = em.createQuery("SELECT j FROM JobOffer j", JobOffer.class);
        return q.getResultList();
    }

    public List<JobOffer> findByAreaIn(Set<String> areas) {
        if (areas == null || areas.isEmpty()) return List.of();
        TypedQuery<JobOffer> q = em.createQuery("SELECT j FROM JobOffer j WHERE j.area IN :areas", JobOffer.class);
        q.setParameter("areas", areas);
        return q.getResultList();
    }

    public List<JobOffer> findOpenOffers() {
        TypedQuery<JobOffer> q = em.createQuery("SELECT j FROM JobOffer j WHERE j.closed = false", JobOffer.class);
        return q.getResultList();
    }

    public void save(JobOffer entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    public JobOffer update(JobOffer entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            JobOffer merged = em.merge(entity);
            tx.commit();
            return merged;
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }

    public void deleteById(Long id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            JobOffer entity = em.find(JobOffer.class, id);
            if (entity != null) em.remove(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
}