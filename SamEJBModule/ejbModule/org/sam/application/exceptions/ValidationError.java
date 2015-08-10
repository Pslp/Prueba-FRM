package org.sam.application.exceptions;

/**
 * Esta clase permite representar un error de validacion en un dto o entidad del
 * negocio.
 * 
 * @author Nestor
 * @version 1.0
 * @created 26-May-2014 12:38:29 a.m.
 */
public class ValidationError {

	/**
	 * Mensaje de error.
	 */
	private String error;
	/**
	 * Propiedad donde se produce el error
	 */
	private String property;

	/**
	 * 
	 * @param property
	 * @param error
	 */
	public ValidationError(String property, String error) {

	}

	public String getError() {
		return error;
	}

	public String getProperty() {
		return property;
	}

	/**
	 * 
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * 
	 * @param property
	 */
	public void setProperty(String property) {
		this.property = property;
	}

}