package org.sam.security.dto;

import java.io.Serializable;
import java.util.List;

import org.sam.security.SecurityRole;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private List<SecurityRole> roles;
	private Long legajo;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public List<SecurityRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SecurityRole> roles) {
		this.roles = roles;
	}
}