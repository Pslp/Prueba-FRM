package org.sam.syllabus;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * @author Angel Ortega
 * 
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CourseService implements CourseServiceRemote {

	// /*
	// * (non-Javadoc)
	// *
	// * @see org.sam.syllabus.CourseServiceRemote#findAllCourseState()
	// */
	// @Override
	// public List<CourseState> findAllCourseState() {
	// return CourseState.values();
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.sam.syllabus.CourseServiceRemote#findAllCourseDuratio()
	// */
	// @Override
	// public List<CourseDuration> findAllCourseDuratio() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.sam.syllabus.CourseServiceRemote#findAllCorrelativityType()
	// */
	// @Override
	// public List<CorrelativityType> findAllCorrelativityType() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
