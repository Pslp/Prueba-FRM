package org.sam.syllabus;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.sam.syllabus.dto.SyllabusDTO;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SyllabusService implements SyllabusServiceRemote {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sam.syllabus.SyllabusServiceRemote#findAllSyllabus()
	 */
	@Override
	public List<SyllabusDTO> findAllSyllabus() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sam.syllabus.SyllabusServiceRemote#registerSyllabus(org.sam.syllabus
	 * .dto.SyllabusDTO)
	 */
	@Override
	public void registerSyllabus(SyllabusDTO syllabusDTO) {
		// TODO Auto-generated method stub

	}

}
