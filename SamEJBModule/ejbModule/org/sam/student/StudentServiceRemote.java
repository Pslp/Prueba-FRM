package org.sam.student;

import java.util.List;

import javax.ejb.Remote;

import org.sam.student.dto.AcademicStatusDTO;
import org.sam.student.dto.StudentDTO;

/**
 * @author Angel Ortega
 * 
 */
@Remote
public interface StudentServiceRemote {

	/**
	 * Registra un nuevo estudiante
	 * 
	 * @param student
	 */
	public void registerStudent(StudentDTO student);

	/**
	 * 
	 * Elimina un estudiante del sistema
	 * 
	 * @param legajo
	 */
	public void removeStudent(Long legajo);

	/**
	 * 
	 * Buscaun estudiante por legajo
	 * 
	 * @param legajo
	 * @return
	 */
	public StudentDTO findStudent(Long legajo);

	/**
	 * Lista todos los estudiantes del sistema
	 * 
	 * //TODO ver se va a utilizar ?
	 * 
	 * @return
	 */
	public List<StudentDTO> listAllStudent();

	/**
	 * 
	 * Actualiza un estudiante existente
	 * 
	 * @param student
	 */
	public void updateStudent(StudentDTO student);

	/**
	 * 
	 * Registra un estado academico para el estudiaante
	 * 
	 * @param legajo
	 * @param academicStatus
	 */
	public void registerAcademicStatus(Long legajo, AcademicStatusDTO academicStatus);

	/**
	 * Registra todos los estados academicos del estudiante 
	 * 
	 * @param legajo
	 * @param academicStatus
	 */
	public void registerAllAcademicStatus(Long legajo, List<AcademicStatusDTO> academicStatus);

	/**
	 * 
	 * Lista el estado academico del estudiante
	 * 
	 * @param legajo
	 * @param careerId
	 * @return
	 */
	public List<AcademicStatusDTO> listStudentAcademicStatus(Long legajo, Long careerId);

}
