package org.sam.syllabus;

/**
 * @author Angel Ortega
 * @version 1.0
 * @created 27-May-2014 10:50:22 p.m.
 * 
 *          Tipos de correlatividad para : {Final, Aprobar, cursar}
 */
public enum CorrelativityType {
	FINAL("Para Examen Final")// TODO sobra una ?
	, PASS("Para Aprobar"), TAKE("Para cursar");
	private String name;

	private CorrelativityType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}