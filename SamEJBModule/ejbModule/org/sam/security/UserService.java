/**
 * 
 */
package org.sam.security;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.sam.security.dto.UserDTO;
import org.sam.security.dto.UserDTOFactory;
import org.sam.security.entities.User;
import org.sam.security.repository.UserRepository;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserService implements UserServiceRemote {

	@EJB
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.utn.sam.security.UserServiceRemote#findByLogin(java.lang.String)
	 */
	@Override
	public UserDTO findByLogin(String login) {
		User user = userRepository.findById(login);
		return UserDTOFactory.buildUserDTO(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.utn.sam.security.UserServiceRemote#registerUser(org.utn.sam.security
	 * .dto.UserDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UserDTO registerUser(UserDTO userDTO) {
		userRepository.add(UserDTOFactory.buildUser(userDTO));
		User user = userRepository.findById(userDTO.getLogin());
		return UserDTOFactory.buildUserDTO(user);
	}

	/**
	 * Elimina un usuario por login Este método no es accesible desde las
	 * interfaces remotas
	 * 
	 * @param login
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeUSer(String login) {
		User toRemove = userRepository.findById(login);
		userRepository.remove(toRemove);
	}
}
