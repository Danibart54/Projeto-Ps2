package main.java.br.com.portal.dao;

import br.com.portal.model.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CompanyDAO {

    private final EntityManager em;

    public CompanyDAO(EntityManager em) {
        this.em = em;
    }

    public Optional<Company> findById(Long id) {
        return Optional.ofNullable(em.find(Company.class, id));
    }

    public Optional<Company> findByCnpj(String cnpj) {
        TypedQuery<Company> q = em.createQuery("SELECT c FROM Company c WHERE c.cnpj = :cnpj", Company.class);
        q.setParameter("cnpj", cnpj);
        List<Company> list = q.getResultList();
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    public List<Company> findAll() {
        TypedQuery<Company> q = em.createQuery("SELECT c FROM Company c", Company.class);
        return q.getResultList();
    }

    public void save(Company entity) {
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

    public Company update(Company entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Company merged = em.merge(entity);
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
            Company entity = em.find(Company.class, id);
            if (entity != null) em.remove(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
}