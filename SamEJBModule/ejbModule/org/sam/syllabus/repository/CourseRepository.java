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
import org.sam.syllabus.entities.Course;

@Stateless
@LocalBean
public class CourseRepository implements Repository<Course, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(Course newOne) throws EntityExistsException {
		entityManager.persist(newOne);
	}

	@Override
	public Course findById(Long id) throws EntityNotFoundException {
		return entityManager.find(Course.class, id);
	}

	@Override
	public List<Course> getAll() {
		String q = "SELECT c from " + Course.class.getName() + " c ";
		TypedQuery<Course> query = entityManager.createQuery(q, Course.class);
		return query.getResultList();
	}

	@Override
	public long size() {
		String q = "SELECT count(c) from " + Course.class.getName() + " c ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

	@Override
	public void remove(Course toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);
	}

}
