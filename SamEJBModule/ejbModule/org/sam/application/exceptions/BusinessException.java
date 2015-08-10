package org.sam.application.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ApplicationException;

/**
 * Representa una ecepcion del negocio. Agrega una propedad que identifica el
 * componente en donde se origina el error. Asi mismo define que es una
 * transaccion que debe realizar rollbak en la transaccion.
 * 
 * @author Nestor
 * @version 1.0
 * @created 26-May-2014 12:38:29 a.m.
 */
@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -445890439850367761L;

	private List<ValidationError> errores = new ArrayList<ValidationError>();

	/**
	 * 
	 * @param componente
	 * @param message
	 */
	public BusinessException(String componente, String message) {

	}

	/**
	 * 
	 * @param message
	 */
	public BusinessException(String message) {

	}

	/**
	 * 
	 * @param mensaje
	 * @param errores
	 */
	public BusinessException(String mensaje, List<ValidationError> errores) {

	}

	public List<ValidationError> getErrores() {
		return errores;
	}

	/**
	 * 
	 * @param errores
	 */
	public void setErrores(List<ValidationError> errores) {
		errores = errores;
	}

}