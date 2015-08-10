package org.sam.student.dto;

import java.util.ArrayList;
import java.util.List;

import org.sam.security.dto.UserDTO;
import org.sam.security.dto.UserDTOFactory;
import org.sam.security.entities.User;
import org.sam.student.entities.Student;

/**
 * 
 * Factory para DTOs de Students
 * 
 * @author Angel Ortega
 * 
 */
public class StudentDTOFactory {

	/**
	 * construye un studentDTO a partir de un student
	 * 
	 * @param student
	 * @return
	 */
	public static StudentDTO buildStudentDTO(Student student) {
		StudentDTO dto = null;
		if (student != null) {
			dto = new StudentDTO();
			dto.setLastName(student.getLastName());
			dto.setName(student.getName());
			dto.setMail(student.getMail());
			dto.setRegisterDate(student.getRegisterDate());
			UserDTO user = UserDTOFactory.buildUserDTO(student.getUser());
			dto.setUser(user);
		}
		return dto;
	}

	/**
	 * 
	 * construye un student a partir de un studentDto
	 * 
	 * @param studentDTO
	 * @return
	 */
	public static Student buildStudent(StudentDTO studentDTO) {
		Student student = null;
		if (studentDTO != null) {
			student = new Student();
			student.setLegajo(studentDTO.getLegajo());
			student.setLastName(studentDTO.getLastName());
			student.setName(studentDTO.getName());
			student.setMail(studentDTO.getMail());
			student.setRegisterDate(studentDTO.getRegisterDate());
			User user = UserDTOFactory.buildUser(studentDTO.getUser());
			student.setUser(user);
		}

		return student;
	}

	/**
	 * construye una lista de studentDTO a partir de una lista de student
	 * 
	 * @param studentList
	 * @return
	 */
	public static List<StudentDTO> buildStudentDTO(List<Student> studentList) {
		List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		for (Student student : studentList) {
			studentDTOList.add(buildStudentDTO(student));
		}
		return studentDTOList;
	}
}
