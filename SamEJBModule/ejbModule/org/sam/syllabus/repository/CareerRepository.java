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
import org.sam.syllabus.entities.Career;

@Stateless
@LocalBean
public class CareerRepository implements Repository<Career, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(Career newOne) throws EntityExistsException {
		entityManager.persist(newOne);
	}

	@Override
	public Career findById(Long id) throws EntityNotFoundException {
		return entityManager.find(Career.class, id);
	}

	@Override
	public List<Career> getAll() {
		String q = "SELECT c from " + Career.class.getName() + " c ";
		TypedQuery<Career> query = entityManager.createQuery(q, Career.class);
		return query.getResultList();
	}

	@Override
	public long size() {
		String q = "SELECT count(c) from " + Career.class.getName() + " c ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

	@Override
	public void remove(Career toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);
	}

}
