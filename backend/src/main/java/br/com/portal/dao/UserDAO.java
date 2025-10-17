package main.java.br.com.portal.dao;

import br.com.portal.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDAO {

    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    public Optional<User> findByEmail(String email) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        q.setParameter("email", email);
        List<User> list = q.getResultList();
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    public List<User> findAll() {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);
        return q.getResultList();
    }

    public void save(User entity) {
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

    public User update(User entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User merged = em.merge(entity);
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
            User entity = em.find(User.class, id);
            if (entity != null) em.remove(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
} 