package org.sam.syllabus.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:23 p.m.
 * 
 *          Plan de estudios de la CareerCourse
 */

@Entity
public class Syllabus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String plan;
	private Date initDate;
	private Date endDate;

	public String getPlan() {
		return plan;
	}

	/**
	 * 
	 * @param plan
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getInitDate() {
		return initDate;
	}

	/**
	 * 
	 * @param initDate
	 */
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}