package org.sam.syllabus;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 * 
 *          Estado de las materias, para el alumno y para correlatividades
 */
public enum CourseState {
	PASS("Aprobada"), REGULARIZED("Regular"), IN_COURSE("Cursando");
	private String name;

	private CourseState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}