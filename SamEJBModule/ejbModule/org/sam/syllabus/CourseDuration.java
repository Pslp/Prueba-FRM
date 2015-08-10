package org.sam.syllabus;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 * 
 *          Duracion de las materias
 */
public enum CourseDuration {
	HALF_YEAR("Semestral"), YEAR("Anual");
	private String name;

	private CourseDuration(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}