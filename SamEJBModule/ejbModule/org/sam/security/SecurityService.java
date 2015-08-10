/**
 * 
 */
package org.sam.security;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.sam.application.exceptions.BusinessException;
import org.sam.security.dto.UserDTO;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SecurityService implements SecurityServiceRemote {
	@EJB
	private UserService userService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.utn.sam.security.SecurityServiceRemote#login(java.lang.String)
	 */
	@Override
	public UserDTO login(String login) {
		UserDTO user = userService.findByLogin(login);
		if (user == null) {
			throw new BusinessException("Usuario no encontrado.");
		}
		return user;
	}

}
