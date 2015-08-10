package org.sam.application.repository;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

/**
 * Interfaz Repository de acceso a datos. Esta interfaz es utilizada para
 * implementar el acceso a datos del repositorio en forma estandariazada en
 * todos los repositorios de la aplicacion.
 * 
 * @param <E>
 *            Tipo de objeto de la entidad administrada.
 * @param <I>
 *            Tipo de datos utilizado como identidad del objeto.
 * @author Nestor
 * @version 1.0
 * @created 26-May-2014 12:38:29 a.m.
 */
public interface Repository<E, I> {

	/**
	 * Agrega un objeto al repositorio.
	 * 
	 * @return Objeto agregado.
	 * 
	 * @param newOne
	 *            Objeto a agregar.
	 * @exception EntityExistsException
	 */
	public void add(E newOne) throws EntityExistsException;

	/**
	 * Consulta en el repositorio por la entidad cuyo ID coincide con el
	 * parametro.
	 * 
	 * @return La entidad buscada o bien null si no existe.
	 * 
	 * @param id
	 *            El id a buscar.
	 * @exception EntityNotFoundException
	 */
	public E findById(I id) throws EntityNotFoundException;

	/**
	 * Devuelve un listado con todas las entidades contenidas en el repositorio.
	 * 
	 * @return Listado de entidades, null si esta vacia.
	 */
	public List<E> getAll();

	/**
	 * Elimina el objeto del repositorio.
	 * 
	 * @param toRemove
	 *            Objeto a eliminar.
	 * @exception EntityNotFoundException
	 */
	public void remove(E toRemove) throws EntityNotFoundException;

	/**
	 * Devuelve la cantidad de objetos contenidos en el repositorio.
	 * 
	 * @return Cantidad de objetos en el repositorio.
	 */
	public long size();

}