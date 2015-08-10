package org.sam.student.dto;

import java.io.Serializable;
import java.util.Date;

import org.sam.security.dto.UserDTO;

/**
 * @author Angel Ortega
 * 
 *         Dto de estudiantes
 * 
 */
public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long legajo;
	private String name;
	private String lastName;
	private String mail;
	private Date registerDate;
	private UserDTO user;

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}