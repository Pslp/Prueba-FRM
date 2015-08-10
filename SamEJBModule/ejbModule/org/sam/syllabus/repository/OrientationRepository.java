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
import org.sam.syllabus.entities.Orientation;

@Stateless
@LocalBean
public class OrientationRepository implements Repository<Orientation, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(Orientation newOne) throws EntityExistsException {
		entityManager.persist(newOne);
	}

	@Override
	public Orientation findById(Long id) throws EntityNotFoundException {
		return entityManager.find(Orientation.class, id);
	}

	@Override
	public void remove(Orientation toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);
	}

	@Override
	public List<Orientation> getAll() {
		String q = "SELECT o from " + Orientation.class.getName() + " o ";
		TypedQuery<Orientation> query = entityManager.createQuery(q, Orientation.class);
		return query.getResultList();
	}

	@Override
	public long size() {
		String q = "SELECT count(o) from " + Orientation.class.getName() + " o ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

}
