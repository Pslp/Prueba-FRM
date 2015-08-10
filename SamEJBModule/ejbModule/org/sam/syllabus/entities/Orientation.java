package org.sam.syllabus.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:23 p.m.
 * 
 *          Orientacion de la CareerCourse
 */
@Entity
public class Orientation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}