package org.sam.security.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.sam.security.SecurityRole;
import org.sam.student.entities.Student;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:23 p.m.
 * 
 *          mapea un usuario del sistema
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	private String login;
	@NotEmpty
	private String password;

	@ElementCollection(targetClass = SecurityRole.class)
	@Enumerated(EnumType.STRING)
	@JoinTable(name = "userrol")
	@JoinColumn(name = "usuarioId")
	private java.util.List<SecurityRole> roles = new ArrayList<SecurityRole>();

	@OneToOne(mappedBy = "user")
	private Student student;

	/**
	 * 
	 * @param role
	 */
	public boolean addRole(SecurityRole role) {
		return roles.add(role);
	}

	public java.util.List<SecurityRole> getRoles() {
		return roles;
	}

	public void clearRoles() {
		roles.clear();
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoles(java.util.List<SecurityRole> roles) {
		this.roles = roles;
	}

	/**
	 * 
	 * @param role
	 */
	public boolean containsRole(SecurityRole role) {
		return roles.contains(role);
	}

	public Student getStudent() {
		return student;
	}

	public String getLogin() {
		return login;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param role
	 */
	public boolean removeRole(SecurityRole role) {
		return roles.remove(role);
	}

	/**
	 * 
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}