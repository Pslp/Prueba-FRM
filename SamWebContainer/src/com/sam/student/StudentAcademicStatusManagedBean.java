package com.sam.student;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.sam.security.dto.UserDTO;
import org.sam.student.StudentServiceRemote;
import org.sam.student.dto.AcademicStatusDTO;
import org.sam.syllabus.CourseServiceRemote;
import org.sam.syllabus.CourseState;

import com.sam.application.Constants;

/**
 * @author Angel Ortega
 * 
 */

@ManagedBean
@ViewScoped
public class StudentAcademicStatusManagedBean {

	@EJB
	private StudentServiceRemote studentService;
	@EJB
	private CourseServiceRemote courseService;

	List<AcademicStatusDTO> academicStatusList;

	CourseState[] courseStateArray = CourseState.values();

	@PostConstruct
	private void initialize() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		UserDTO user = (UserDTO) externalContext.getSessionMap().get(Constants.SESSION_USER);

		if (user.getLegajo() != null) {
			Long carreerId = 1l;// TODO FIXME recuperar del formulario
			academicStatusList = studentService.listStudentAcademicStatus(user.getLegajo(), carreerId);
		}
	}

	/**
	 * obtiene el estado academico del alumno
	 * 
	 * @param legajo
	 * @return
	 */
	public List<AcademicStatusDTO> getAcademicStatusList() {
		return academicStatusList;
	}

	public String academicStatusSave() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		UserDTO user = (UserDTO) externalContext.getSessionMap().get(Constants.SESSION_USER);
		studentService.registerAllAcademicStatus(user.getLegajo(), academicStatusList);
		return "/index.xhtml";

	}

	public String academicStatusRemove() {
		return "";
	}

	public CourseState[] getCourseStateArray() {
		return courseStateArray;
	}

}
