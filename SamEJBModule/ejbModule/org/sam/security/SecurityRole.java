package org.sam.security;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:23 p.m.
 * 
 *          posibles roles del sistema
 */
public enum SecurityRole { 
	ADMIN("Administrador"), STUDENT("Estudiante");
	private String name;

	private SecurityRole(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}