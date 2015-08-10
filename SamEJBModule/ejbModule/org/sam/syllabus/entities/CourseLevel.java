package org.sam.syllabus.entities;

/**
 * @author Angel Ortega
 * 
 */
public enum CourseLevel {
	PRIMERO(1), SEGUNDO(2), TERCERO(3), CUARTO(4), QUINTO(5);
	int level;

	private CourseLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
