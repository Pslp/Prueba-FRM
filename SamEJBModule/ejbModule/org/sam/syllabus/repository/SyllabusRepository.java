package org.sam.syllabus.repository;

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
import org.sam.syllabus.entities.Syllabus;

/**
 * @author Angel Ortega
 *
 */
@Stateless
@LocalBean
public class SyllabusRepository implements Repository<Syllabus, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(Syllabus newOne) throws EntityExistsException {
		entityManager.persist(newOne);
	}

	@Override
	public Syllabus findById(Long id) throws EntityNotFoundException {
		return entityManager.find(Syllabus.class, id);
	}

	@Override
	public void remove(Syllabus toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);

	}

	@Override
	public List<Syllabus> getAll() {
		String q = "SELECT s from " + Syllabus.class.getName() + " s ";
		TypedQuery<Syllabus> query = entityManager.createQuery(q, Syllabus.class);
		return query.getResultList();
	}

	@Override
	public long size() {
		String q = "SELECT count(s) from " + Syllabus.class.getName() + " s ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

}
