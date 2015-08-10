package org.sam.syllabus.dto;

import java.io.Serializable;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 * 
 *          DTO de materia
 */
public class CourseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}