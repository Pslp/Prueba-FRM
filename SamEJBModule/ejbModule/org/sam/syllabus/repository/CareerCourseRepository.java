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
import org.sam.syllabus.entities.CareerCourse;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
public class CareerCourseRepository implements Repository<CareerCourse, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(CareerCourse newOne) throws EntityExistsException {
		entityManager.persist(newOne);
	}

	@Override
	public CareerCourse findById(Long id) throws EntityNotFoundException {
		return entityManager.find(CareerCourse.class, id);
	}

	@Override
	public void remove(CareerCourse toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);
	}

	@Override
	public List<CareerCourse> getAll() {
		String q = "SELECT c from " + CareerCourse.class.getName() + " c ";
		TypedQuery<CareerCourse> query = entityManager.createQuery(q, CareerCourse.class);
		return query.getResultList();
	}

	@Override
	public long size() {
		String q = "SELECT count(c) from " + CareerCourse.class.getName() + " c ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

}
