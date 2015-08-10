package org.sam.syllabus.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.sam.syllabus.CourseDuration;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 26-May-2014 11:51:17 p.m.
 */
@Entity
public class CareerCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@NotNull
	private Course Course;

	@ManyToOne
	private Career career;

	@ManyToOne
	private Syllabus syllabus;

	@ManyToOne
	private Orientation orientation;

	@Enumerated(EnumType.STRING)
	private CourseDuration duration;

	@OneToMany(mappedBy = "careerCourse")
	private List<Correlativity> correlatives;

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private CourseLevel courseLevel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Course getCourse() {
		return Course;
	}

	public void setCourse(Course course) {
		Course = course;
	}

	public Syllabus getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public List<Correlativity> getCorrelatives() {
		return correlatives;
	}

	public void setCorrelatives(List<Correlativity> correlatives) {
		this.correlatives = correlatives;
	}

	public CourseDuration getDuration() {
		return duration;
	}

	public void setDuration(CourseDuration duration) {
		this.duration = duration;
	}

	public CourseLevel getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(CourseLevel courseLevel) {
		this.courseLevel = courseLevel;
	}

}