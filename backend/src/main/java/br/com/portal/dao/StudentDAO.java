package main.java.br.com.portal.dao;

import br.com.portal.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class StudentDAO {

    private final EntityManager em;

    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(em.find(Student.class, id));
    }

    public Optional<Student> findByCpf(String cpf) {
        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s WHERE s.cpf = :cpf", Student.class);
        q.setParameter("cpf", cpf);
        List<Student> list = q.getResultList();
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(0));
    }

    public List<Student> findAll() {
        TypedQuery<Student> q = em.createQuery("SELECT s FROM Student s", Student.class);
        return q.getResultList();
    }

    public void save(Student entity) {
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

    public Student update(Student entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student merged = em.merge(entity);
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
            Student entity = em.find(Student.class, id);
            if (entity != null) em.remove(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        }
    }
}