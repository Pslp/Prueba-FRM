package org.sam.syllabus;

import java.util.List;

import javax.ejb.Remote;

import org.sam.syllabus.dto.SyllabusDTO;

/**
 * @author Angel Ortega
 * 
 */
@Remote
public interface SyllabusServiceRemote {

	/**
	 * recupera la lista de todos los planes de estudio existentes
	 * 
	 * 
	 * @return
	 */
	public List<SyllabusDTO> findAllSyllabus();

	/**
	 * Registra un nuevo plan de estudios
	 * 
	 * @param syllabusDTO
	 */
	public void registerSyllabus(SyllabusDTO syllabusDTO);
}
