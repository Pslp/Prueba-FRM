package org.sam.security;

import javax.ejb.Remote;

import org.sam.security.dto.UserDTO;

/**
 * @author Angel Ortega
 * 
 * @version 1.0
 * 
 */
@Remote
public interface UserServiceRemote {
	public abstract UserDTO findByLogin(String login);

	public abstract UserDTO registerUser(UserDTO userDTO);
}