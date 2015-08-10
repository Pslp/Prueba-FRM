package org.sam.security.dto;

import java.io.Serializable;

public class RegistrarUserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userLogin;
	private String userPassword;
	private String userConfirmpassword;
	private String userName;
	private String userLastname;
	private String userMail;
	private Long userLegajo;
	
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
	
	
}
