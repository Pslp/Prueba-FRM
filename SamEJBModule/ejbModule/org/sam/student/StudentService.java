/**
 * 
 */
package org.sam.student;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.sam.student.dto.AcademicStatusDTO;
import org.sam.student.dto.AcademicStatusDTOFactory;
import org.sam.student.dto.StudentDTO;
import org.sam.student.dto.StudentDTOFactory;
import org.sam.student.entities.AcademicStatus;
import org.sam.student.entities.Student;
import org.sam.student.repository.AcademicStatusRepository;
import org.sam.student.repository.StudentRepository;
import org.sam.syllabus.CourseState;
import org.sam.syllabus.entities.CareerCourse;
import org.sam.syllabus.repository.CareerCourseRepository;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StudentService implements StudentServiceRemote {
	@EJB
	private StudentRepository studentRepository;
	@EJB
	private CareerCourseRepository careerCourseRepository;
	@EJB
	private AcademicStatusRepository academicStatusRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.utn.sam.student.StudentServiceRemote#registerStudent(org.utn.sam.
	 * student.dto.StudentDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registerStudent(StudentDTO studentDTO) {
		Student student = StudentDTOFactory.buildStudent(studentDTO);
		studentRepository.add(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.utn.sam.student.StudentServiceRemote#removeStudent(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeStudent(Long legajo) {
		Student toRemove = studentRepository.findById(legajo);
		studentRepository.remove(toRemove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.utn.sam.student.StudentServiceRemote#findStudent(java.lang.Long)
	 */
	@Override
	public StudentDTO findStudent(Long legajo) {
		Student student = studentRepository.findById(legajo);
		return StudentDTOFactory.buildStudentDTO(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.utn.sam.student.StudentServiceRemote#listAllStudent()
	 */
	@Override
	public List<StudentDTO> listAllStudent() {
		return StudentDTOFactory.buildStudentDTO(studentRepository.getAll());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.utn.sam.student.StudentServiceRemote#updateStudent(org.utn.sam.student
	 * .dto.StudentDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateStudent(StudentDTO studentDto) {
		Student student = studentRepository.findById(studentDto.getLegajo());
		student.setLastName(studentDto.getName());
		student.setName(studentDto.getName());
		student.setMail(studentDto.getMail());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.utn.sam.student.StudentServiceRemote#registerAcademicStatus(java.
	 * lang.Long, org.utn.sam.student.dto.AcademicStatusDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registerAcademicStatus(Long legajo, AcademicStatusDTO academicStatusDTO) {
		Student student = studentRepository.findById(legajo);

		AcademicStatus as = new AcademicStatus();
		CareerCourse careerCourse = careerCourseRepository.findById(academicStatusDTO.getCareerCourseId());
		as.setCareerCourse(careerCourse);
		as.setStudent(student);
		as.setDate(academicStatusDTO.getDate());
		as.setCourseState(CourseState.valueOf(academicStatusDTO.getCourseState()));
		student.addAcademicStatus(as);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registerAllAcademicStatus(Long legajo, List<AcademicStatusDTO> academicStatus) {
		Student student = studentRepository.findById(legajo);
		// student.clearAcademicStatus();
		AcademicStatus as;
		for (AcademicStatusDTO academicStatusDTO : academicStatus) {
			if (academicStatusDTO.getId() != null) {
				as = academicStatusRepository.findById(academicStatusDTO.getId());
			} else {
				as = new AcademicStatus();
			}
			CareerCourse careerCourse = careerCourseRepository.findById(academicStatusDTO.getCareerCourseId());
			as.setCareerCourse(careerCourse);
			as.setStudent(student);
			as.setDate(academicStatusDTO.getDate());
			as.setCourseState(CourseState.valueOf(academicStatusDTO.getCourseState()));
			student.addAcademicStatus(as);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sam.student.StudentServiceRemote#listStudentAcademicStatus(java.lang
	 * .Long, java.lang.Long)
	 */
	@Override
	public List<AcademicStatusDTO> listStudentAcademicStatus(Long legajo, Long careerId) {
		List<AcademicStatus> academicStatusList = academicStatusRepository.findByLegajoAndCarreerId(legajo, careerId);
		return AcademicStatusDTOFactory.buildAcademicStatusDTO(academicStatusList);
	}
}
