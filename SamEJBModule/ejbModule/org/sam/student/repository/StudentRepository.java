package org.sam.student.repository;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.sam.application.Constants;
import org.sam.application.repository.Repository;
import org.sam.student.entities.Student;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
public class StudentRepository implements Repository<Student, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(Student newOne) throws EntityExistsException {
		entityManager.persist(newOne);
	}

	@Override
	public Student findById(Long legajo) throws EntityNotFoundException {
		return entityManager.find(Student.class, legajo);
	}

	@Override
	public List<Student> getAll() {
		String q = "select s from " + Student.class.getName() + " s";
		TypedQuery<Student> query = entityManager.createQuery(q, Student.class);
		return query.getResultList();
	}

	@Override
	public void remove(Student toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);

	}

	@Override
	public long size() {
		String q = "SELECT count(s) from " + Student.class.getName() + " s ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

}
