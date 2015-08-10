package com.sam.security;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.sam.application.exceptions.BusinessException;
import org.sam.security.SecurityService;
import org.sam.security.SecurityServiceRemote;
import org.sam.security.dto.UserDTO;

import com.sam.application.Constants;

/**
 * @author Angel Ortega
 * 
 */
@ManagedBean
@RequestScoped
public class AuthenticationManagedBean {
	@EJB
	private SecurityServiceRemote securityService;
	// campos del formulario de login
	private String userLogin;
	private String userPassword;
	private String redirectURL;

	/**
	 * 
	 * Login al sistema
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public String login() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();

		try {
			// login manejado por el jboss
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			request.login(userLogin, userPassword);
			
			UserDTO user = securityService.login(userLogin);

			externalContext.getSessionMap().put(Constants.SESSION_USER, user);

			// una vez que nos logueamos volvemos al index
			return "/index.xhtml?faces-redirect=true";
		} catch (BusinessException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Usuario o contraseña inválido."));
		}
		return null;
	}

	/**
	 * logout del sistema, limpiar session
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public String logout() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		// invalido la session
		externalContext.invalidateSession();
		// regresamos al index
		return "/index.xhtml?faces-redirect=true";
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

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

}