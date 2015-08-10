package org.sam.student.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sam.security.entities.User;
import org.sam.syllabus.entities.Career;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:23 p.m.
 * 
 *          Representa un Alumno de una carrera
 */
@Entity
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long legajo;
	private String name;
	private String lastName;
	private String mail;
	/**
	 * fecha y hora de registro del alumno en el sistema
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	/**
	 * carreras que cursa el alumno
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "studentCarrer")
	private List<Career> career = new ArrayList<Career>();

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<AcademicStatus> academicStatus = new ArrayList<AcademicStatus>();

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public List<Career> getCareer() {
		return career;
	}

	public void setCareer(List<Career> career) {
		this.career = career;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<AcademicStatus> getAcademicStatus() {
		return academicStatus;
	}

	public void setAcademicStatus(List<AcademicStatus> academicStatus) {
		this.academicStatus = academicStatus;
	}

	public boolean containsAcademicStatus(AcademicStatus as) {
		return academicStatus.contains(as);
	}

	public void clearAcademicStatus() {
		academicStatus.clear();;
	}
	public boolean addAcademicStatus(AcademicStatus as) {
		return academicStatus.add(as);
	}

	public boolean removeAcademicStatus(AcademicStatus as) {
		return academicStatus.remove(as);
	}
}