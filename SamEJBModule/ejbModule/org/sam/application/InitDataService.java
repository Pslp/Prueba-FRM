package org.sam.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.sam.security.SecurityRole;
import org.sam.security.entities.User;
import org.sam.security.repository.UserRepository;
import org.sam.student.entities.AcademicStatus;
import org.sam.student.entities.Student;
import org.sam.student.repository.StudentRepository;
import org.sam.syllabus.CourseDuration;
import org.sam.syllabus.CourseState;
import org.sam.syllabus.entities.Career;
import org.sam.syllabus.entities.CareerCourse;
import org.sam.syllabus.entities.Correlativity;
import org.sam.syllabus.entities.Course;
import org.sam.syllabus.entities.CourseLevel;
import org.sam.syllabus.entities.Orientation;
import org.sam.syllabus.entities.Syllabus;
import org.sam.syllabus.repository.CareerCourseRepository;
import org.sam.syllabus.repository.CareerRepository;
import org.sam.syllabus.repository.CourseRepository;
import org.sam.syllabus.repository.OrientationRepository;
import org.sam.syllabus.repository.SyllabusRepository;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InitDataService {
	@EJB
	private UserRepository userRepository;
	@EJB
	private StudentRepository studentRepository;
	@EJB
	private CareerRepository careerRepository;
	@EJB
	private CourseRepository courseRepository;
	@EJB
	private SyllabusRepository syllabusRepository;
	@EJB
	private OrientationRepository orientationRepository;
	@EJB
	private CareerCourseRepository careerCourseRepository;

	public void insertData() {

		// PLAN DE ESTUDIOS

		// planes de estudio
		Syllabus plan95 = new Syllabus();
		plan95.setPlan("Plan 95");
		syllabusRepository.add(plan95);

		// carreras
		Career systemas = new Career();
		systemas.setName("Ing. en Sistemas de información");
		careerRepository.add(systemas);

		// orientaciones
		Orientation desarrollo = new Orientation();
		desarrollo.setName("Desarrollo");
		orientationRepository.add(desarrollo);

		/******* MATERIAS *********/

		/** AM I **/
		Course ami = new Course();
		ami.setName("AM I");
		courseRepository.add(ami);

		// primero las q no tienen correlativas y las de 1° año
		CareerCourse amiPlan95 = new CareerCourse();
		amiPlan95.setSyllabus(plan95); // plan
		amiPlan95.setCareer(systemas);// carrera
		amiPlan95.setCourse(ami);// materia
		amiPlan95.setCourseLevel(CourseLevel.PRIMERO);
		amiPlan95.setDuration(CourseDuration.HALF_YEAR);
		amiPlan95.setOrientation(desarrollo);

		// Correlatividad - ami no tiene correlativas
		amiPlan95.setCorrelatives(new ArrayList<Correlativity>());
		careerCourseRepository.add(amiPlan95);

		/** ALGEBRA **/
		Course algebra = new Course();
		algebra.setName("Algebra");
		courseRepository.add(algebra);

		CareerCourse algebraPlan95 = new CareerCourse();
		algebraPlan95.setSyllabus(plan95); // plan
		algebraPlan95.setCareer(systemas);// carrera
		algebraPlan95.setCourse(algebra);// materia
		algebraPlan95.setCourseLevel(CourseLevel.PRIMERO);
		algebraPlan95.setDuration(CourseDuration.HALF_YEAR);
		algebraPlan95.setOrientation(desarrollo);

		// Correlatividad - ami no tiene correlativas
		algebraPlan95.setCorrelatives(new ArrayList<Correlativity>());
		careerCourseRepository.add(algebraPlan95);
		
		
		
		
		
		
		
		
		
		
		{
		/** Proyecto final **/
		Course proyectoFinal = new Course();
		proyectoFinal.setName("Algebra");
		courseRepository.add(proyectoFinal);

		CareerCourse ProyectoFinalPlan95 = new CareerCourse();
		ProyectoFinalPlan95.setSyllabus(plan95); // plan
		ProyectoFinalPlan95.setCareer(systemas);// carrera
		ProyectoFinalPlan95.setCourse(proyectoFinal);// materia
		ProyectoFinalPlan95.setCourseLevel(CourseLevel.QUINTO);
		ProyectoFinalPlan95.setDuration(CourseDuration.YEAR);
		ProyectoFinalPlan95.setOrientation(desarrollo);

		// Correlatividad - ami no tiene correlativas
		ProyectoFinalPlan95.setCorrelatives(new ArrayList<Correlativity>());
		careerCourseRepository.add(ProyectoFinalPlan95);
	}
		/********* ESTADO ACADEMICO MIO**************************/
		
		
		// MI ESTADO ACADEMICO
		Student angel = new Student();
		angel.setLastName("Ortega");
		angel.setName("Angel");
		angel.setLegajo(24462l);
		angel.setMail("angel.ortega@alumnos.frm.utn.edu.ar");
		angel.setRegisterDate(new Date(2001, 03, 01));

		User user = new User();
		user.setLogin("matute");
		user.setPassword("ISMvKXpXpadDiUoOSoAfww==");
		List<SecurityRole> roles = new ArrayList<SecurityRole>();
		roles.add(SecurityRole.STUDENT);
		user.setRoles(roles);
		angel.setUser(user);

		
		
		// AcademicStatus para ami
		AcademicStatus ami_angel = new AcademicStatus();
		ami_angel.setStudent(angel);
		ami_angel.setCareerCourse(amiPlan95);
		ami_angel.setDate(new Date(2001, 9, 5));
		ami_angel.setCourseState(CourseState.PASS);
		angel.addAcademicStatus(ami_angel);

		
		// AcademicStatus para algebra
		AcademicStatus algebrai_angel = new AcademicStatus();
		algebrai_angel.setStudent(angel);
		algebrai_angel.setCareerCourse(algebraPlan95);
		algebrai_angel.setDate(new Date(2001, 9, 5));
		algebrai_angel.setCourseState(CourseState.PASS);
		angel.addAcademicStatus(algebrai_angel);
		studentRepository.add(angel);
		
	}

	public void removeDataInserted() {
		Student angel = studentRepository.findById(24462l);
		studentRepository.remove(angel);
	}
}
