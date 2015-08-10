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
import org.sam.student.entities.AcademicStatus;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
public class AcademicStatusRepository implements Repository<AcademicStatus, Long> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(AcademicStatus newOne) throws EntityExistsException {
		entityManager.persist(AcademicStatus.class);

	}

	@Override
	public AcademicStatus findById(Long id) throws EntityNotFoundException {
		return entityManager.find(AcademicStatus.class, id);
	}

	@Override
	public List<AcademicStatus> getAll() {
		String q = "select s from " + AcademicStatus.class.getName() + " s";
		TypedQuery<AcademicStatus> query = entityManager.createQuery(q, AcademicStatus.class);
		return query.getResultList();
	}

	@Override
	public void remove(AcademicStatus toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);

	}

	@Override
	public long size() {
		String q = "SELECT count(s) from " + AcademicStatus.class.getName() + " s ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

	/**
	 * 
	 * Busca los estados academicos para el alumno y la carrera indicados
	 * 
	 * @param legajo
	 * @param careerId
	 * @return
	 */
	public List<AcademicStatus> findByLegajoAndCarreerId(Long legajo, Long careerId) {
		String q = "select s from " + AcademicStatus.class.getName() + " s where s.student.legajo=? and s.careerCourse.career.id=?";
		TypedQuery<AcademicStatus> query = entityManager.createQuery(q, AcademicStatus.class);
		query.setParameter(1, legajo);
		query.setParameter(2, careerId);
		return query.getResultList();
	}

}
