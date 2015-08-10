package org.sam.syllabus.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sam.syllabus.CorrelativityType;
import org.sam.syllabus.CourseState;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 * 
 *          Mapea la correlatividad entre materias
 */
@Entity
public class Correlativity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date initDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Enumerated(EnumType.STRING)
	private CourseState courseState;

	@Enumerated(EnumType.STRING)
	private CorrelativityType type;

	@ManyToOne
	private CareerCourse careerCourse;

	@ManyToOne
	private CareerCourse correlative;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CourseState getCourseState() {
		return courseState;
	}

	public void setCourseState(CourseState courseState) {
		this.courseState = courseState;
	}

	public CorrelativityType getType() {
		return type;
	}

	public void setType(CorrelativityType type) {
		this.type = type;
	}

	public CareerCourse getCareerCourse() {
		return careerCourse;
	}

	public void setCareerCourse(CareerCourse careerCourse) {
		this.careerCourse = careerCourse;
	}

	public CareerCourse getCorrelative() {
		return correlative;
	}

	public void setCorrelative(CareerCourse correlative) {
		this.correlative = correlative;
	}

}