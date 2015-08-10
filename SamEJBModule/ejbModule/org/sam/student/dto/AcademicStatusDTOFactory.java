package org.sam.student.dto;

import java.util.ArrayList;
import java.util.List;

import org.sam.student.entities.AcademicStatus;

/**
 * 
 * Factory para dto academicStatusDTO
 * 
 * @author Angel Ortega
 * 
 */
public class AcademicStatusDTOFactory {

	/**
	 * @param academicStatus
	 * @return
	 */
	public static AcademicStatusDTO buildAcademicStatusDTO(AcademicStatus academicStatusList) {
		AcademicStatusDTO academicStatusDTO = new AcademicStatusDTO();
		academicStatusDTO.setId(academicStatusList.getId());
		academicStatusDTO.setCareerCourseId(academicStatusList.getCareerCourse().getId());
		academicStatusDTO.setCareerCourseName(academicStatusList.getCareerCourse().getCourse().getName());
		academicStatusDTO.setCourseLevel(academicStatusList.getCareerCourse().getCourseLevel().getLevel());
		academicStatusDTO.setCourseLevelName(academicStatusList.getCareerCourse().getCourseLevel().name());
		academicStatusDTO.setCourseLevel(academicStatusList.getCareerCourse().getCourseLevel().getLevel());
		academicStatusDTO.setCourseState(academicStatusList.getCourseState().name());
		academicStatusDTO.setCourseStateName(academicStatusList.getCourseState().getName());
		
		academicStatusDTO.setDate(academicStatusList.getDate());
		return academicStatusDTO;
	}

	/**
	 * @param academicStatusList
	 * @return
	 */
	public static List<AcademicStatusDTO> buildAcademicStatusDTO(List<AcademicStatus> academicStatusList) {
		List<AcademicStatusDTO> dtos = new ArrayList<AcademicStatusDTO>();
		for (AcademicStatus as : academicStatusList) {
			dtos.add(buildAcademicStatusDTO(as));
		}
		return dtos;
	}

}
