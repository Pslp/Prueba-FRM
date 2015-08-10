package com.sam.application;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.sam.application.InitDataService;
import org.sam.security.SecurityRole;
import org.sam.security.UserService;
import org.sam.security.dto.UserDTO;

/**
 * @author Angel Ortega
 * 
 *         inicializo el contexto, creo un usuario Admin con rol Admin
 */
public class SamContextListener implements ServletContextListener {
	@EJB
	UserService userService;

	@EJB
	InitDataService initDataService;

	@Override
	public void contextInitialized(ServletContextEvent event) {

		System.out.println("************contextInitialized*****************");
		if (userService.findByLogin("admin") != null)
			userService.removeUSer("admin");

		UserDTO user = new UserDTO();
		List<SecurityRole> roles = new ArrayList<SecurityRole>();
		roles.add(SecurityRole.ADMIN);

		user.setLogin("admin");
		user.setPassword("ISMvKXpXpadDiUoOSoAfww==");
		user.setRoles(roles);
		userService.registerUser(user);

		System.out.println("************User admin created, pass admin*****************");
		initDataService.insertData();
		System.out.println("************Status academicus insertauts *****************");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("************REMOVING ANGEL *****************");
		initDataService.removeDataInserted();
		System.out.println("************contextDestroyed*****************");
	}

}
