package org.sam.security;

import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sam.security.dto.UserDTO;

/**
 * @author Angel Ortega
 * 
 * @version 1.0
 * 
 */
@Remote
public interface SecurityServiceRemote {

	/**
	 * realiza el logueo del usuario con el login indicado
	 * 
	 * @param login
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public abstract UserDTO login(String login);
}