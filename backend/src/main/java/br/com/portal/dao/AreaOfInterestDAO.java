// ...existing code...
package main.java.br.com.portal.dao;

import br.com.portal.model.AreaOfInterest;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * DAO JPA simples para AreaOfInterest.
 * Use um EntityManager fornecido pela camada de persistência (JPA/Hibernate).
 */
public class AreaOfInterestDAO {

    private final EntityManager em;

    public AreaOfInterestDAO(EntityManager em) {
        this.em = em;
    }

    public Optional<AreaOfInterest> findById(Long id) {
        return Optional.ofNullable(em.find(AreaOfInterest.class, id));
    }

    public List<AreaOfInterest> findAll() {
        TypedQuery<AreaOfInterest> q = em.createQuery("SELECT a FROM AreaOfInterest a", AreaOfInterest.class);
        return q.getResultList();
    }

    public void save(AreaOfInterest entity) {
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

    public AreaOfInterest update(AreaOfInterest entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            AreaOfInterest merged = em.merge(entity);
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
            AreaOfInterest entity = em.find(AreaOfInterest.class, id);
            if (entity != null) em.remove(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
}