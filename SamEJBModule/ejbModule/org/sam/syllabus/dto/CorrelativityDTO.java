package org.sam.syllabus.dto;

import java.io.Serializable;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 * 
 *          Mapea la correlatividad entre materias
 */
public class CorrelativityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String courseState;
	private String type;
	private String course; // nombre de la materia correlativa

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseState() {
		return courseState;
	}

	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}