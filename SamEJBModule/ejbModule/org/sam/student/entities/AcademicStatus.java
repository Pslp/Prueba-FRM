package org.sam.student.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.sam.syllabus.CourseState;
import org.sam.syllabus.entities.CareerCourse;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 */
@Entity
public class AcademicStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Fecha en la que se obtuvo el estado para la materia
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	@ManyToOne
	@NotNull
	private CareerCourse careerCourse;

	@Enumerated(EnumType.STRING)
	@NotNull
	private CourseState courseState;

	@ManyToOne
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public CareerCourse getCareerCourse() {
		return careerCourse;
	}

	public void setCareerCourse(CareerCourse careerCourse) {
		this.careerCourse = careerCourse;
	}

	public CourseState getCourseState() {
		return courseState;
	}

	public void setCourseState(CourseState courseState) {
		this.courseState = courseState;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}