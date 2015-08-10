package org.sam.security.repository;

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
import org.sam.security.entities.User;

@Stateless
@LocalBean
public class UserRepository implements Repository<User, String> {
	@PersistenceContext(unitName = Constants.PERSISTENCE_UNIT_SAM)
	private EntityManager entityManager;

	@Override
	public void add(User user) throws EntityExistsException {
		entityManager.persist(user);
	}

	@Override
	public User findById(String login) throws EntityNotFoundException {
		return entityManager.find(User.class, login);
	}

	@Override
	public List<User> getAll() {
		String q = "SELECT u from " + User.class.getName() + " u ";
		TypedQuery<User> query = entityManager.createQuery(q, User.class);
		return query.getResultList();
	}

	@Override
	public long size() {
		String q = "SELECT count(u) from " + User.class.getName() + " u ";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}

	@Override
	public void remove(User toRemove) throws EntityNotFoundException {
		entityManager.remove(toRemove);
	}
}
