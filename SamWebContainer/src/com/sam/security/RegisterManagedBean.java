package com.sam.security;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.sam.application.exceptions.BusinessException;
import org.sam.application.exceptions.ValidationError;
import org.sam.security.SecurityServiceRemote;
import org.sam.security.dto.UserDTO;
import org.sam.student.StudentServiceRemote;
import org.sam.student.dto.StudentDTO;


/**
 * @author LegendOfSteel
 * 
 */
@ManagedBean
@RequestScoped
public class RegisterManagedBean {
	@EJB
	private SecurityServiceRemote securityService;
	@EJB
	private StudentServiceRemote studentService;
	
	private StudentDTO usuarioEditado;
	
	//campos del formulario de registro
	private String userLogin;
	private String userPassword;
	private String userConfirmpassword;
	private String userName;
	private String userLastname;
	private String userMail;
	private Long userLegajo;
	private String redirectURL;
	
	@PostConstruct
	private void initialize() {
		if (usuarioEditado == null) {
			usuarioEditado = new StudentDTO();
			usuarioEditado.setUser(new UserDTO());
		}
	}	
	
	public String register() throws IOException {
		if (!validateSave()) {
			return null;
		}
		
		try {
			
			usuarioEditado.setLastName(userLastname);
			usuarioEditado.setLegajo(userLegajo);
			usuarioEditado.setMail(userMail);
			usuarioEditado.setName(userName);
			usuarioEditado.getUser().setPassword(userPassword);
			usuarioEditado.getUser().setLogin(userLogin);
			
			studentService.registerStudent(usuarioEditado);
			return "usuario";
		} catch (BusinessException e) {
			processBusinessException(e);
		} catch (ConstraintViolationException cve) {
			processConstraintViolationException(cve);
		} catch (EJBException e) {
			if (e.getCause().getClass().isAssignableFrom(ConstraintViolationException.class)) {
				processConstraintViolationException((ConstraintViolationException) e.getCause());
			} else if (e.getCause().getClass().isAssignableFrom(BusinessException.class)) {
				processBusinessException((BusinessException) e.getCause());
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error inesperado del sistema. No se pudo agregar el usuario.", e.getMessage()));
		}
		return null;
	}

	public boolean validateSave() {
		if (userPassword.trim().length() > 0 || userConfirmpassword.trim().length() > 0) {
			if (!userPassword.equals(userConfirmpassword)) {
				FacesContext.getCurrentInstance().addMessage("form:userPassword", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden.", "Las contraseñas no coinciden."));
			} else {
				usuarioEditado.getUser().setPassword(userPassword);
			}
		}

		return FacesContext.getCurrentInstance().getMessageList().isEmpty();
	}
	
	private void processBusinessException(BusinessException e) {
		BusinessException be = (BusinessException) e;
		if (be.getErrores().size() > 0) {
			for (ValidationError ve : be.getErrores()) {
				FacesContext.getCurrentInstance().addMessage("form:" + ve.getProperty(), new FacesMessage(FacesMessage.SEVERITY_ERROR, ve.getError(), ve.getError()));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, be.getMessage(), be.getMessage()));
		}
	}
	
	private void processConstraintViolationException(ConstraintViolationException cve) {
		for (ConstraintViolation<?> v : cve.getConstraintViolations()) {
			FacesContext.getCurrentInstance().addMessage("form:" + v.getPropertyPath().toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, v.getMessage(), v.getMessage()));
		}
	}
	
	public SecurityServiceRemote getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityServiceRemote securityService) {
		this.securityService = securityService;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserConfirmpassword() {
		return userConfirmpassword;
	}

	public void setUserConfirmpassword(String userConfirmpassword) {
		this.userConfirmpassword = userConfirmpassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Long getUserLegajo() {
		return userLegajo;
	}

	public void setUserLegajo(Long userLegajo) {
		this.userLegajo = userLegajo;
	}
	
	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}
	
	
}
