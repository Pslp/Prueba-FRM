package org.sam.student.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Angel Ortega
 * 
 */
public class AcademicStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date date;

	private Long careerCourseId;
	private String careerCourseName; // materia

	private String courseState; // valor de la enum
	private String courseStateName; // regular , en curso, Aprobada

	private int courseLevel; // año de cursado
	private String courseLevelName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCareerCourseName() {
		return careerCourseName;
	}

	public void setCareerCourseName(String careerCourseName) {
		this.careerCourseName = careerCourseName;
	}

	public String getCourseState() {
		return courseState;
	}

	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}

	public int getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(int courseLevel) {
		this.courseLevel = courseLevel;
	}

	public Long getCareerCourseId() {
		return careerCourseId;
	}

	public void setCareerCourseId(Long careerCourseId) {
		this.careerCourseId = careerCourseId;
	}

	public String getCourseStateName() {
		return courseStateName;
	}

	public void setCourseStateName(String courseStateName) {
		this.courseStateName = courseStateName;
	}

	public String getCourseLevelName() {
		return courseLevelName;
	}

	public void setCourseLevelName(String courseLevelName) {
		this.courseLevelName = courseLevelName;
	}

}